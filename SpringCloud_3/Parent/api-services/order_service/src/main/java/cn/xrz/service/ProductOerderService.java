package cn.xrz.service;

import cn.xrz.entity.ProductOerder;

/**
 * @author XRZ
 * @date 2019-04-21
 * @Description :
 */
public interface ProductOerderService {

    ProductOerder save(int userId,int productId);
}
