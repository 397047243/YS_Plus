package cn.appsys.service.backenduser;

import cn.appsys.dao.backenduser.BackendUserMapper;
import cn.appsys.pojo.BackendUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author XRZ
 * @date 2019\3\6 0006
 * @Description :
 */
@Service("backendUserService")
public class BackendUserServiceImpl implements BackendUserService {

    @Resource
    private BackendUserMapper backendUserMapper;

    @Override
    public BackendUser login(String userCode, String userPassword) throws Exception {
        return this.backendUserMapper.login(userCode,userPassword);
    }
}
