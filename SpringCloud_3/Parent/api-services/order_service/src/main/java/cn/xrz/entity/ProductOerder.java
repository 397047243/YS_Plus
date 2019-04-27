package cn.xrz.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author XRZ
 * @date 2019-04-21
 * @Description :
 */
@Data
public class ProductOerder {

    private int id;
    private String productNmae;
    private String tradeNo;
    private double price;
    private Date createTime;
    private int userId;
    private String userNmae;

}
