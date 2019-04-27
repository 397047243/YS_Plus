package cn.xrz.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author XRZ
 * @date 2019-04-21
 * @Description : 商品实体类
 */
@Data
public class Product implements Serializable {

    private int id;
    private String name;    //商品名称
    private double price;   //价格
    private int store;      //库存

    public Product(){}

    public Product(int id, String name, double price, int store) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.store = store;
    }
}
