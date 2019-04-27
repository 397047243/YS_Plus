package cn.xrz.base;

import lombok.Data;

/**
 * @author XRZ
 * @date 2019-04-19
 * @Description : 服务接口响应类
 */
@Data
public class ResponseBase {

    private Integer rtnCode;
    private String msg;
    private Object data;

    public ResponseBase(){}

    public ResponseBase(Integer rtnCode, String msg, Object data) {
        this.rtnCode = rtnCode;
        this.msg = msg;
        this.data = data;
    }
}
