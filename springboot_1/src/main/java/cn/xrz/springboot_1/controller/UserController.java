package cn.xrz.springboot_1.controller;

import cn.xrz.springboot_1.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author XRZ
 * @date 2019-04-12
 * @Description : 用户服务
 *                  测试异步执行
 */
@RestController
@Slf4j
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/register")
    public String register() throws ExecutionException, InterruptedException {
        log.info("===========[1]=========");

        Future<String> future = userService.sendEmail();

        log.info("===========[4]=========");

        return future.get();
    }
}
