package cn.appsys.service.devuser;


import cn.appsys.pojo.DevUser;

/**
 * @author XRZ
 * @date 2019\3\3 0003
 * @Description :
 */
public interface DevService {

    /**
     * 根据用户编码和密码返回用户
     * @param devCode
     * @param devPassword
     * @return
     */
    DevUser getUser(String devCode, String devPassword) throws Exception;

}
