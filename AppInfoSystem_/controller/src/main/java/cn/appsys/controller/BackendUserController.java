package cn.appsys.controller;

import cn.appsys.pojo.AppInfo;
import cn.appsys.pojo.BackendUser;
import cn.appsys.service.appcategory.AppCategoryService;
import cn.appsys.service.appinfo.AppInfoService;
import cn.appsys.service.appsersion.AppVersionService;
import cn.appsys.service.backenduser.BackendUserService;
import cn.appsys.service.datadictionary.DataDictionaryService;
import cn.appsys.tools.Constants;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author XRZ
 * @date 2019\3\6 0006
 * @Description :
 */
@Controller
@RequestMapping("/bac")
public class BackendUserController {

    @Resource
    private BackendUserService backendUserService;
    @Resource
    private AppInfoService appInfoService;
    @Resource
    private DataDictionaryService dataDictionaryService;
    @Resource
    private AppCategoryService appCategoryService;
    @Resource
    private AppVersionService appVersionService;

    /**
     * 登录页面跳转
     * @return
     */
    @RequestMapping("/login")
    public String login(){
        return "Login_backend";
    }


    @RequestMapping("/loginSub")
    public String loginSub(@RequestParam("userCode") String userCode,
                           @RequestParam("userPassword") String userPassword, HttpSession session, Model model){
        try {
            BackendUser user = this.backendUserService.login(userCode, userPassword);
            if(null != user){
                session.setAttribute(Constants.USER_SESSION_BAC,user); //设置Session
                return "backend/main"; //进入主页
            }
            model.addAttribute("error","账号或者密码错误，请重新再试！");
        } catch (Exception e) {
            model.addAttribute("error","系统异常，请稍后再试！");
            e.printStackTrace();
        }
        return "Login_backend"; //返回登录页面
    }

    /**
     * 退出登录
     * @param session
     * @return
     */
    @RequestMapping("/logout")
    public void logOut(HttpServletResponse response, HttpSession session){
        session.removeAttribute(Constants.USER_SESSION_BAC); //清除Session
        try {
            response.sendRedirect("../index.jsp"); //重定向至首页
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /***
     * 返回主页
     * @return
     */
    @RequestMapping("/main")
    public String returnMain(){
        return "backend/main";
    }

    /**
     * 显示所有待审核的APPinfo
     * @param appInfo
     * @param model
     * @param pageIndex
     * @return
     */
    @RequestMapping("/list")
    public String list(AppInfo appInfo, Model model,
                           @RequestParam(value = "pageIndex",required = false) Integer pageIndex){
        pageIndex = pageIndex == null ? 1:pageIndex; //非空验证
        appInfo.setStatus(1);//所有状态均为带审核
        model.addAttribute("appinfo",appInfo);//用于回显
        try {
            PageHelper.startPage(pageIndex,5);
            List<AppInfo> appinfoList = this.appInfoService.getList(appInfo);
            PageInfo<AppInfo> page = new PageInfo<>(appinfoList); //获取分页详细信息
            model.addAttribute("appInfoList",appinfoList);//APP信息集合
            model.addAttribute("totalPageCount", page.getPages()); //总页数
            model.addAttribute("totalCount", page.getTotal()); //总条数
            model.addAttribute("currentPageNo", pageIndex); //当前页数
            model.addAttribute("isPrev", page.isHasPreviousPage()); //是否有上一页
            model.addAttribute("isNext", page.isHasNextPage()); //是否有下一页
            model.addAttribute("flatFormList",this.dataDictionaryService.getByTypeCode("APP_FLATFORM"));//平台集合
            model.addAttribute("categoryLevel1List",this.appCategoryService.getByCode("ALL"));//一级分类集合
            //根据一级分类获取二级分类集合
            model.addAttribute("categoryLevel2List",this.appCategoryService.getByParentId(appInfo.getCategoryLevel1()+""));
            //根据二级分类获取三级分类集合
            model.addAttribute("categoryLevel3List",this.appCategoryService.getByParentId(appInfo.getCategoryLevel2()+""));
//            System.err.println(appInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        int i = 1/0;
        return "backend/applist";
    }

    /**
     * APP审核
     * @param aid
     * @param vid
     * @param model
     * @return
     */
    @RequestMapping("/appcheck")
    public String appCheck(@RequestParam("aid") String aid,
                           @RequestParam("vid") String vid,Model model){
        try {
            model.addAttribute("appInfo",this.appInfoService.getById(aid)); //设置appinfo的信息
            model.addAttribute("appVersion",this.appVersionService.getById(vid)); //设置appVersion的信息
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "backend/appcheck";
    }

    /**
     * 提交审核
     * @param id
     * @param status
     * @return
     */
    @RequestMapping("/checksave")
    public String checkSave(@RequestParam("id") String pid,
                            @RequestParam("status") Integer status,Model model){
        try {
            if(this.appInfoService.updateSatus(status,pid) > 0){
                return "redirect:list"; //修改成功
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("error","很抱歉,服务器异常！");
        return "backend/appcheck";//失败返回审核页面
    }
}
