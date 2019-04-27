package cn.xrz.service;

import cn.xrz.entity.Product;

import java.util.List;

/**
 * @author XRZ
 * @date 2019-04-21
 * @Description :
 */
public interface ProductService {

    List<Product> listProduct();

    Product findById(int id);

}
