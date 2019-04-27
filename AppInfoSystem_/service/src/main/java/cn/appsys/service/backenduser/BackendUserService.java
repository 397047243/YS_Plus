package cn.appsys.service.backenduser;

import cn.appsys.pojo.BackendUser;

/**
 * @author XRZ
 * @date 2019\3\6 0006
 * @Description :
 */
public interface BackendUserService {


    /**
     * 根据用户名这密码返回对象
     * @param userCode
     * @param userPassword
     * @return
     */
    BackendUser login(String userCode, String userPassword) throws Exception;

}
