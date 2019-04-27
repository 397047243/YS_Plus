package cn.xrz.controller_Impl;

import cn.xrz.base.BaseApiService;
import cn.xrz.base.ResponseBase;
import cn.xrz.controller.ProductOerderController;
import cn.xrz.service.ProductOerderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author XRZ
 * @date 2019-04-21
 * @Description :
 */
@RestController
@RequestMapping("/order")
public class ProductOerderControllerImpl extends BaseApiService implements ProductOerderController {

//    @Autowired
//    private StringRedisTemplate redisTemplate;

    @Autowired
    private ProductOerderService productOerderService;

    /**
     * 解决服务雪崩效应的 (Hystrix有两种方式配置保护服务，接口、注解)
     *
     *      @HystrixCommand 默认开启线程池隔离方式，服务降级，服务熔断（默认阈值10）
     *          fallbackMethod：指定服务降级时执行的方法
     *
     *      注意：Hystrix 默认客户端调用该接口时，如果超过1秒，则会执行服务降级方法
     *
     */
    @HystrixCommand(fallbackMethod = "saveHystrixFallback")
    @Override
    @GetMapping("/save")
    public ResponseBase save(@RequestParam("userId") Integer userId, @RequestParam("productId") Integer productId){
        return super.setResultSuccess(productOerderService.save(userId,productId));
    }

    public ResponseBase saveHystrixFallback(Integer userId,Integer productId){

        //监控报警

        System.out.println(userId+"==============="+productId);
        return setResultSuccess("服务降级：服务繁忙，目前下单人数过多，请稍后再试！");

    }
}
