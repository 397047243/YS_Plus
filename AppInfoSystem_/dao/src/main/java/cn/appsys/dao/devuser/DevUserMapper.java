package cn.appsys.dao.devuser;

import cn.appsys.pojo.DevUser;
import org.apache.ibatis.annotations.Param;

/**
 * @author XRZ
 * @date 2019\3\3 0003
 * @Description :
 */
public interface DevUserMapper {

    /**
     * 根据用户编码和密码返回用户
     * @param devCode
     * @param devPassword
     * @return
     */
    DevUser getUser(@Param("devCode") String devCode, @Param("devPassword") String devPassword);

}
