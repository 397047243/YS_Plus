package cn.xrz.controller_Impl;

import cn.xrz.base.BaseApiService;
import cn.xrz.base.ResponseBase;
import cn.xrz.controller.ProductController;
import cn.xrz.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/product")
public class ProductControllerImpl extends BaseApiService implements ProductController {


    @Autowired
    private ProductService productService;

    @Override
    @GetMapping("/list")
    public ResponseBase list() {
        return super.setResultSuccess(productService.listProduct());
    }

    @Override
    @GetMapping("/findById")
    public ResponseBase findById(@RequestParam("id") Integer id) {
        return super.setResultSuccess(productService.findById(id));
    }
}
