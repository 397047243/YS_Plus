package cn.xrz.base;

/**
 * @author XRZ
 * @date 2019-04-19
 * @Description : 服务接口响应封装类，统一规范响应服务接口信息
 */
public class BaseApiService {

    public ResponseBase setResultError(Integer code,String msg){
        return setResult(code,msg,null);
    }

    public ResponseBase setResultError(String msg){
        return setResult(500,msg,null);
    }

    public ResponseBase setResultSuccess(Object data){
        return  setResult(200,"处理成功",data);
    }

    public ResponseBase setResultSuccess(){
        return  setResult(200,"处理成功",null);
    }

    public ResponseBase setResultSuccess(String msg){
        return  setResult(200,msg,null);
    }


    /**
     * 通用封装
     * @param code
     * @param msg
     * @param data
     * @return
     */
    public ResponseBase setResult(Integer code,String msg,Object data){
        return new ResponseBase(code,msg,data);
    }

}
