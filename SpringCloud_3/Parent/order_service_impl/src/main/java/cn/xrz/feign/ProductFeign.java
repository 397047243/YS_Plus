package cn.xrz.feign;

import cn.xrz.controller.ProductController;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author XRZ
 * @date 2019-04-21
 * @Description : 商品服务客户端
 *
 *          FeignClient（name="指定链接的服务",fallback=指定容错处理类）
 *
 */
@FeignClient(name = "app-xrz-product")
public interface ProductFeign extends ProductController {
}
