package cn.xrz.springboot_1.controller;

import cn.xrz.springboot_1.Springboot1Application;
import cn.xrz.springboot_1.entity.Student;
import cn.xrz.springboot_1.service.StudentService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author XRZ
 * @date 2019-04-12
 * @Description :
 */
@RestController // 表示改类中的所有方法返回json格式 同等 @Controller + @ResponseBody
public class MemberController {

    @Resource
    private StudentService studentService;

    @Value("${username}") //注入applicatuib.properties中声明的值 (启动时就注入)
    private String userName;

    @RequestMapping("/helloworld")
    public String helloWorld(){
        return "hello World!";
    }

    @RequestMapping("/testvalue")
    public String testvalue(){
        return userName;
    }

    /**
     * 测试mybatis
     * @param name
     * @return
     */
    @RequestMapping("/teststudent")
    public String teststudent(@RequestParam("name") String name){
        return studentService.findByNmae(name).toString();
    }

    /**
     * 测试事务
     * @param name
     * @return
     */
    @Transactional //Propagation.REQUIRED      默认 使用调用方法的事务 （即B调用A，在A方法中使用B的事务）
    @RequestMapping("/testtransactional")
    public String testtransactional(@RequestParam("name") String name,@RequestParam("password") String password){
        int insert = studentService.insert(name, password);
        int i = 1/0;
        return insert+"";
    }

    /**
     * 测试分页
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping("/testpageHelper")
    public PageInfo<Student> testPageHelper(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize){
        return studentService.getList(pageNo,pageSize);
    }



}
