package cn.xrz.springboot_1.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author XRZ
 * @date 2019-04-12
 * @Description :
 */
@Data //lombok 为类的所有属性自动生成setter/getter、equals、canEqual、hashCode、toString方法
public class User {

    private String name;
    private String password;

}
