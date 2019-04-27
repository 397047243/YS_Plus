package cn.xrz.springboot_1.error;


import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author XRZ
 * @date 2019-04-12
 * @Description : 捕获全局异常
 */
@Slf4j //lombok 支持的日志
@ControllerAdvice(basePackages = "cn.xrz.springboot_1.controller") //配置捕获的范围 （使用AOP 异常通知实现）
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class) //运行时异常
    @ResponseBody
    public Map<String,Object> errorResult(){

        // 纪录日志...
        log.info("系统错误！-> 500"); //直接使用log 纪录日志 注意需要安装lombok插件

        //设置错误信息
        HashMap<String, Object> map = new HashMap<>();
        map.put("errorCode","500");
        map.put("errorMsg","系统错误！");
        return map;
    }

}
