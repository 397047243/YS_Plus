package cn.xrz.springboot_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author XRZ
 * @date 2019-04-12
 * @Description :
 */
@Controller
public class JSPController {

    @RequestMapping("/hellojsp")
    public String hello(){
        return "index";
    }

    @RequestMapping("/testerror")
    public String testerror(){
        int i = 1/0;
        return "index";
    }

    @RequestMapping("/aaab1")
    public String helloa(){
        return "index";
    }

}
