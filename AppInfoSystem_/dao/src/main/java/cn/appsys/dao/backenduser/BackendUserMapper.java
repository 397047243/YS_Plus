package cn.appsys.dao.backenduser;

import cn.appsys.pojo.BackendUser;
import org.apache.ibatis.annotations.Param;

/**
 * @author XRZ
 * @date 2019\3\6 0006
 * @Description :
 */
public interface BackendUserMapper {

    /**
     * 根据用户名这密码返回对象
     * @param userCode
     * @param userPassword
     * @return
     */
    BackendUser login(@Param("userCode") String userCode, @Param("userPassword") String userPassword) throws Exception;
}
