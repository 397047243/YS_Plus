package cn.xrz.service_Impl;

import cn.xrz.entity.Product;
import cn.xrz.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author XRZ
 * @date 2019-04-21
 * @Description :
 */
@Service("productService")
public class ProductServiceImpl implements ProductService {

    private static final Map<Integer,Product> daoMap = new HashMap<>();


    static {
        daoMap.put(1,new Product(1,"冰箱",2500,10));
        daoMap.put(2,new Product(2,"电视",3500,10));
        daoMap.put(3,new Product(3,"洗衣机",4500,10));
        daoMap.put(4,new Product(4,"风扇",1500,10));
        daoMap.put(5,new Product(5,"电脑",5500,10));
    }

    @Override
    public List<Product> listProduct() {
        return new ArrayList<>(daoMap.values());
    }

    @Override
    public Product findById(int id) {
        return daoMap.get(id);
    }
}
