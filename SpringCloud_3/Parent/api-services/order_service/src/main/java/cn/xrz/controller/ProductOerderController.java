package cn.xrz.controller;

import cn.xrz.base.ResponseBase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author XRZ
 * @date 2019-04-21
 * @Description :
 */
public interface ProductOerderController {

    @GetMapping("/order/save")
    ResponseBase save(@RequestParam("userId") Integer userId,@RequestParam("productId") Integer productId);

}
