package cn.appsys.controller;

import cn.appsys.pojo.AppInfo;
import cn.appsys.pojo.AppVersion;
import cn.appsys.pojo.DevUser;
import cn.appsys.service.appcategory.AppCategoryService;
import cn.appsys.service.appinfo.AppInfoService;
import cn.appsys.service.appsersion.AppVersionService;
import cn.appsys.service.datadictionary.DataDictionaryService;
import cn.appsys.service.devuser.DevService;
import cn.appsys.tools.Constants;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author XRZ
 * @date 2019\3\3 0003
 * @Description :
 */
@Controller
@RequestMapping("/dev")
public class DevUserController {

    @Resource
    private DevService devService;
    @Resource
    private AppInfoService appInfoService;
    @Resource
    private DataDictionaryService dataDictionaryService;
    @Resource
    private AppCategoryService appCategoryService;
    @Resource
    private AppVersionService appVersionService;


    /**
     * 开发者登录
     * @return
     */
    @RequestMapping("/login")
    public String login(){
        return "Login_dev";
    }

    /***
     * 返回主页
     * @return
     */
    @RequestMapping("/main")
    public String returnMain(){
        return "developer/main";
    }

    /**
     * 登录验证
     * @param devCode
     * @param devPassword
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("/loginSub")
    public String loginSub(@RequestParam("devCode") String devCode,
                           @RequestParam("devPassword") String devPassword, HttpSession session, Model model){
        try {
            DevUser devUser = this.devService.getUser(devCode, devPassword);
            if(null != devUser){
                session.setAttribute(Constants.USER_SESSION_DEV,devUser); //设置Session
                return "developer/main"; //进入主页
            }
            model.addAttribute("error","账号或者密码错误，请重新再试！");
        } catch (Exception e) {
            model.addAttribute("error","系统异常，请稍后再试！");
            e.printStackTrace();
        }
        return "Login_dev"; //返回登录页面
    }

    /**
     * 退出登录
     * @param session
     * @return
     */
    @RequestMapping("/logout")
    public void logOut(HttpServletResponse response,HttpSession session){
        session.removeAttribute(Constants.USER_SESSION_DEV); //清除Session
        try {
            response.sendRedirect("../index.jsp"); //重定向至首页
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * APP维护主页
     * @param softwareName
     * @param status
     * @param flatformId
     * @param categoryLevel1
     * @param categoryLevel2
     * @param categoryLevel3
     * @param model
     * @return
     */
    @RequestMapping("/maintain")
    public String mainTain(AppInfo appInfo, Model model,
                           @RequestParam(value = "pageIndex",required = false) Integer pageIndex){
        pageIndex = pageIndex == null ? 1:pageIndex; //非空验证

        model.addAttribute("appinfo",appInfo);//用于回显
        try {
             PageHelper.startPage(pageIndex,5);
            List<AppInfo> appinfoList = this.appInfoService.getList(appInfo);
             PageInfo<AppInfo> page = new PageInfo<>(appinfoList); //获取分页详细信息
             model.addAttribute("appinfolist",appinfoList);//APP信息集合
             model.addAttribute("totalPageCount", page.getPages()); //总页数
             model.addAttribute("totalCount", page.getTotal()); //总条数
             model.addAttribute("currentPageNo", pageIndex); //当前页数
             model.addAttribute("isPrev", page.isHasPreviousPage()); //是否有上一页
             model.addAttribute("isNext", page.isHasNextPage()); //是否有下一页
             model.addAttribute("statuslist",this.dataDictionaryService.getByTypeCode("APP_STATUS"));//状态集合
             model.addAttribute("flatformIdlist",this.dataDictionaryService.getByTypeCode("APP_FLATFORM"));//平台集合
             model.addAttribute("categoryLevel1List",this.appCategoryService.getByCode("ALL"));//一级分类集合
             //根据一级分类获取二级分类集合
             model.addAttribute("categoryLevel2List",this.appCategoryService.getByParentId(appInfo.getCategoryLevel1()+""));
             //根据二级分类获取三级分类集合
             model.addAttribute("categoryLevel3List",this.appCategoryService.getByParentId(appInfo.getCategoryLevel2()+""));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "developer/appinfolist";
    }

    /**
     * 根据父级ID获取分类，返回JSON
     * @param parentId
     * @return
     */
    @ResponseBody
    @RequestMapping("/getcategoryLevel1List")
    public Object getcategoryLevel1List(@RequestParam("parentId") String parentId){
        try {
            return this.appCategoryService.getByParentId(parentId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * 跳转至新增页面
     * @return
     */
    @RequestMapping("/appinfoadd")
    public String appinfoadd(){
        return "developer/appinfoadd";
    }

    /**
     * 获取一级分类集合，返回JSON
     * @return
     */
    @ResponseBody
    @RequestMapping("/getcategoryLevelList_all")
    public Object getcategoryLevelList_all(){
        try {
            return this.appCategoryService.getByCode("ALL");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }

    /**
     * 获取平台集合，返回JSON
     * @return
     */
    @ResponseBody
    @RequestMapping("/getflatform")
    public Object getflatform(@RequestParam("tcode") String tcode){
        try {
            return this.dataDictionaryService.getByTypeCode(tcode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }

    /**
     * 验证APKName是否存在
     * @param APKName
     * @return
     */
    @ResponseBody
    @RequestMapping("/apkexist")
    public Object apkexist(@RequestParam(value = "APKName",required = false) String APKName){
        HashMap<Object, Object> map = new HashMap<>();
        if(APKName == null || APKName == ""){
            map.put("APKName","empty");
        }else {
            try {
                if(this.appInfoService.isAPKName(APKName) > 0){
                    map.put("APKName","exist");
                }else{
                    map.put("APKName","noexist");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return map;
    }

    /**
     * 新增APP信息
     * @param appInfo
     * @param session
     * @param model
     * @param multipartFile
     * @return
     */
    @RequestMapping("/appinfoaddsave")
    public String appinfoaddsave(AppInfo appInfo, HttpServletRequest request, Model model,
                                 @RequestParam("a_logoPicPath") MultipartFile attach){
        model.addAttribute("hx",appInfo);
        //设置路径
        String path = request.getSession().getServletContext().getRealPath("/statics/upload");
        if(!attach.isEmpty()){//判断文件是否为空
            String oldFileName = attach.getOriginalFilename(); //获取源文件名 用于提取后缀
            String prefix = FilenameUtils.getExtension(oldFileName);//获取文件名后缀
            if(attach.getSize() > 5242880){ //验证文件大小
                model.addAttribute("error","上传文件大小超过500k");
                return "developer/appinfoadd"; //添加失败则返回添加页面
            }else if(prefix.equalsIgnoreCase("jpg") || //验证文件格式
                    prefix.equalsIgnoreCase("jpeg") ||
                    prefix.equalsIgnoreCase("png") ||
                    prefix.equalsIgnoreCase("pneg")){
                String fileName = appInfo.getAPKName()+".jpg";  //设置新文件名
                File file = new File(path, fileName); //创建文件对象
                if(!file.exists()){ //如果文件不存在
                    file.mkdirs(); //创建该文件
                }
                try {
                    attach.transferTo(file); //将上传的实体文件复制到指定文件中
                } catch (IOException e) {
                    e.printStackTrace();
                }
                appInfo.setLogoPicPath(request.getContextPath()+ "/statics/upload/" + fileName); //设置相对路径
                appInfo.setLogoLocPath(path + file.separator + fileName); //设置绝对路径
            }else{
                model.addAttribute("error","上传文件格式不正确！");
                return "developer/appinfoadd"; //添加失败则返回添加页面
            }
        }
        //设置相关信息 在Session中获取相关信息
        DevUser devUser = (DevUser) request.getSession().getAttribute(Constants.USER_SESSION_DEV);
        appInfo.setCreatedBy(devUser.getId()); //设置创建人
        appInfo.setCreationDate(new Date()); //设置创建时间
        appInfo.setDevId(devUser.getId()); //设置开发者 ID
        try {
            if(this.appInfoService.addAppInfo(appInfo) == 1){
                return "redirect:maintain"; //添加成功重定向至查询
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("error","很抱歉，服务器异常！");
        return "developer/appinfoadd"; //添加失败则返回添加页面
    }


    /**
     * 根据ID获取APP信息
     * @param id
     * @return
     */
    @RequestMapping("/appview/{id}")
    public String appView(@PathVariable("id") String id, Model model){
        try {
            AppInfo appInfo = this.appInfoService.getById(id);
            model.addAttribute("appInfo",appInfo); //App信息
            model.addAttribute("appVersionList",this.appVersionService.getByAppId(id)); //历史版本
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "developer/appinfoview";
    }


    /**
     * 根据ID 删除 AppInfo及相关版本号信息
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/appdelete")
    public Object appDelete(@RequestParam("id") String id){
        HashMap<Object, Object> map = new HashMap<>();
        try {
            if(this.appInfoService.delById(id) > 0){
                map.put("delResult","true");
            }else{
                map.put("delResult","false");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 修改 回显
     * @param id
     * @return
     */
    @RequestMapping("/appinfomodify")
    public String appInfoModify(@RequestParam("id") String id,Model model){
        try {
            AppInfo appInfo = this.appInfoService.getById(id);
            model.addAttribute("appInfo",appInfo); //App信息
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "developer/appinfomodify";
    }

    /**
     * 删除logo或者APK文件
     * @param id
     * @param flag
     * @return
     */
    @ResponseBody
    @RequestMapping("/delfile")
    public Object delete(@RequestParam("id") String id,@RequestParam("flag") String flag){
        String path = "";
        HashMap<String, String> resultMap = new HashMap<String, String>();
        try {
            if(flag.equals("logo")){ //操作APP_info，获取服务器路径，删除文件
                path = this.appInfoService.getById(id).getLogoLocPath();//获取路径
                File file = new File(path);
                if(file.exists()){ //如果文件存在
                    if(file.delete()){ //如果文件删除成功
                        if(this.appInfoService.delByIdFile(id) > 0) {//删除路径
                            resultMap.put("result","success");
                        }
                    }
                }
            }else{
                path = this.appVersionService.getById(id).getApkLocPath();//获取路径
                File file = new File(path);
                if(file.exists()){ //如果文件存在
                    if(file.delete()){ //如果文件删除成功
                        if(this.appVersionService.delFile(id) > 0) {//删除路径
                            resultMap.put("result","success");
                        }
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return resultMap;
    }


    /**
     * 修改 保存
     * @param appInfo
     * @param request
     * @param model
     * @param attach
     * @return
     */
    @RequestMapping("/updateappinfo")
    public String updateAppInfo(AppInfo appInfo, HttpServletRequest request, Model model,
                                @RequestParam("attach") MultipartFile attach){
        //设置路径
        String path = request.getSession().getServletContext().getRealPath("/statics/upload");
        if(!attach.isEmpty()){//判断文件是否为空
            String oldFileName = attach.getOriginalFilename(); //获取源文件名 用于提取后缀
            String prefix = FilenameUtils.getExtension(oldFileName);//获取文件名后缀
            if(attach.getSize() > 5242880){ //验证文件大小
                model.addAttribute("error","上传文件大小超过500k");
                return "developer/appinfomodify"; //添加失败则返回修改页面
            }else if(prefix.equalsIgnoreCase("jpg") || //验证文件格式
                    prefix.equalsIgnoreCase("jpeg") ||
                    prefix.equalsIgnoreCase("png") ||
                    prefix.equalsIgnoreCase("pneg")){
                String fileName = appInfo.getAPKName()+".jpg";  //设置新文件名
                File file = new File(path, fileName); //创建文件对象
                if(!file.exists()){ //如果文件不存在
                    file.mkdirs(); //创建该文件
                }
                try {
                    attach.transferTo(file); //将上传的实体文件复制到指定文件中
                } catch (IOException e) {
                    e.printStackTrace();
                }
                appInfo.setLogoPicPath(request.getContextPath()+ "/statics/upload/" + fileName); //设置相对路径
                appInfo.setLogoLocPath(path + file.separator + fileName); //设置绝对路径
            }else{
                model.addAttribute("error","上传文件格式不正确！");
                return "developer/appinfomodify"; //添加失败则返回修改页面
            }
        }
        //设置相关信息 在Session中获取相关信息
        DevUser devUser = (DevUser) request.getSession().getAttribute(Constants.USER_SESSION_DEV);
        appInfo.setModifyBy(devUser.getId()); //设置修改人
        appInfo.setModifyDate(new Date()); //设置修改时间
        try {
            if(this.appInfoService.updateAppInfo(appInfo) == 1){
                return "redirect:maintain"; //添加成功重定向至查询
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("error","很抱歉，服务器异常！");
        return "developer/appinfomodify"; //添加失败则返回修改页面
    }

    /**
     * 根据APP ID修改指定状态
     * @param status
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/updatesatus")
    public Object updateSatus(@RequestParam("status") Integer status,@RequestParam("id") String id){
        HashMap<Object, Object> map = new HashMap<>();
        try {
            if(this.appInfoService.updateSatus(status,id) == 1){
                map.put("resultMsg","success");
            }else{
                map.put("resultMsg","failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 新增版本
     * @param id APP ID
     * @return
     */
    @RequestMapping("/appversionadd")
    public String addVersion(@RequestParam("id") Integer id,Model model){
        try {
            //根据id获取版本集合
            model.addAttribute("appVersionList",this.appVersionService.getByAppId(id+""));
            model.addAttribute("appId",id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "developer/appversionadd";
    }

    /**
     *  新增版本 保存
     * @param appVersion
     * @param request
     * @param model
     * @param attach
     * @return
     */
    @RequestMapping("/addversionsave")
    public String addversionsave(AppVersion appVersion,HttpServletRequest request, Model model,
                                 @RequestParam("a_downloadLink") MultipartFile attach){
        //设置路径
        String path = request.getSession().getServletContext().getRealPath("/statics/upload");
        try {
        if(!attach.isEmpty()){//判断文件是否为空
            String oldFileName = attach.getOriginalFilename(); //获取源文件名 用于提取后缀
            String prefix = FilenameUtils.getExtension(oldFileName);//获取文件名后缀
            if(prefix.equalsIgnoreCase("apk")){
                ///设置新文件名 APKName
                String fileName = this.appInfoService.getById(appVersion.getAppId()+"").getAPKName()+appVersion.getVersionNo()+".apk";
                File file = new File(path, fileName); //创建文件对象
                if(!file.exists()){ //如果文件不存在
                    file.mkdirs(); //创建该文件
                }
                attach.transferTo(file); //将上传的实体文件复制到指定文件中
                appVersion.setApkFileName(fileName);
                appVersion.setDownloadLink(request.getContextPath()+ "/statics/upload/" + fileName); //设置相对路径
                appVersion.setApkLocPath(path + file.separator + fileName); //设置绝对路径
            }else{
                model.addAttribute("error","上传文件格式不正确！");
                return "developer/appversionadd"; //添加失败则返回添加页面
            }
        }
        //设置相关信息 在Session中获取相关信息
        DevUser devUser = (DevUser) request.getSession().getAttribute(Constants.USER_SESSION_DEV);
            appVersion.setCreatedBy(devUser.getId()); //设置创建人
            appVersion.setCreationDate(new Date()); //设置创建时间
            int vid = this.appVersionService.add(appVersion); //获取版本ID
            if( vid > 0){
               if(this.appInfoService.updateVersion(appVersion.getAppId(),appVersion.getId()) > 0){ //修改AppInfo版本号
                   return "redirect:maintain"; //添加成功重定向至查询
               }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("error","很抱歉，服务器异常！");
        return "developer/appversionadd";//添加失败则返回添加页面

    }


    /**
     * 修改版本 回显
     * @param pid
     * @param vid
     * @param model
     * @return
     */
    @RequestMapping("/appversionmodify")
    public String appVersionModify(@RequestParam("aid") String pid,@RequestParam("vid") String vid,Model model){
        //根据id获取版本集合
        try {
            model.addAttribute("appVersionList",this.appVersionService.getByAppId(pid));
            model.addAttribute("appVersion",this.appVersionService.getById(vid));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "developer/appversionmodify";
    }

    /**
     * 修改版本 保存
     * @param appVersion
     * @param request
     * @param model
     * @param attach
     * @return
     */
    @RequestMapping("/appversionmodifysave")
    public String appVersionModifySave(AppVersion appVersion,HttpServletRequest request, Model model,
                                       @RequestParam("attach") MultipartFile attach) {
        //设置路径
        String path = request.getSession().getServletContext().getRealPath("/statics/upload");
        try {
            if (!attach.isEmpty()) {//判断文件是否为空
                String oldFileName = attach.getOriginalFilename(); //获取源文件名 用于提取后缀
                String prefix = FilenameUtils.getExtension(oldFileName);//获取文件名后缀
                if (prefix.equalsIgnoreCase("apk")) {
                    ///设置新文件名 APKName
                    String fileName = this.appInfoService.getById(appVersion.getAppId() + "").getAPKName() + appVersion.getVersionNo() + ".apk";
                    File file = new File(path, fileName); //创建文件对象
                    if (!file.exists()) { //如果文件不存在
                        file.mkdirs(); //创建该文件
                    }
                    attach.transferTo(file); //将上传的实体文件复制到指定文件中
                    appVersion.setApkFileName(fileName);
                    appVersion.setDownloadLink(request.getContextPath() + "/statics/upload/" + fileName); //设置相对路径
                    appVersion.setApkLocPath(path + file.separator + fileName); //设置绝对路径
                } else {
                    model.addAttribute("error", "上传文件格式不正确！");
                    return "developer/appversionmodify"; //添加失败则返回添加页面
                }
            }
            //设置相关信息 在Session中获取相关信息
            DevUser devUser = (DevUser) request.getSession().getAttribute(Constants.USER_SESSION_DEV);
            appVersion.setModifyBy(devUser.getId()); //设置修改人
            appVersion.setModifyDate(new Date()); //设置修改时间
            if(this.appVersionService.update(appVersion) > 0){
                return "redirect:maintain"; //修改成功重定向至查询
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("error", "很抱歉，服务器异常！");
        return "developer/appversionmodify";//修改失败则返回添加页面
    }


//    /**
//     * 可指定异常处理，参数为空则触发所有异常类型错误
//     * @param ex
//     * @param request
//     * @return
//     */
//    @ExceptionHandler(value = {IOException.class, SQLException.class})
//    public String exp(Exception ex,HttpServletRequest request){
//        request.setAttribute("ex",ex);
//        return "异常页面";
//    }
}
