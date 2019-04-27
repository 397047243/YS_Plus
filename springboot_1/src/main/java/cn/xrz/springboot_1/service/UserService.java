package cn.xrz.springboot_1.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * @author XRZ
 * @date 2019-04-12
 * @Description :
 */
@Service
@Slf4j
public class UserService {


    /**
     * 发送邮件
     * @return  Future 异步回调的返回值
     */
    @Async //异步调用   原理 AOP实现
    public Future<String> sendEmail() {
        log.info("===========[2]=========");
        //发送邮件
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("===========[3]=========");

        return new AsyncResult<String>("发送邮件成功！");
    }



}
