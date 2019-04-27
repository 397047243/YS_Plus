package cn.xrz.service_Impl;

import cn.xrz.base.ResponseBase;
import cn.xrz.entity.Product;
import cn.xrz.entity.ProductOerder;
import cn.xrz.feign.ProductFeign;
import cn.xrz.service.ProductOerderService;
import cn.xrz.tools.JsonUtil;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author XRZ
 * @date 2019-04-21
 * @Description :
 */
@Service("productOerderService")
public class ProductOrderServiceImpl implements ProductOerderService {

    @Autowired
    private ProductFeign productFeign;

    @Override
    public ProductOerder save(int userId, int productId) {
        ResponseBase responseBase = productFeign.findById(productId); //获取返回结果

        LinkedHashMap<String,Object> data = (LinkedHashMap<String, Object>) responseBase.getData();

        ProductOerder productOerder = new ProductOerder();
        productOerder.setCreateTime(new Date());
        productOerder.setUserId(userId);
        productOerder.setTradeNo(UUID.randomUUID().toString());
        productOerder.setProductNmae(data.get("name").toString());
        productOerder.setPrice(Double.valueOf(data.get("price").toString()));

        return productOerder;
    }
}
