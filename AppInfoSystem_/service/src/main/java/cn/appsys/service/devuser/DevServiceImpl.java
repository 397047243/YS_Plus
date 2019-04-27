package cn.appsys.service.devuser;

import cn.appsys.dao.devuser.DevUserMapper;
import cn.appsys.pojo.DevUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author XRZ
 * @date 2019\3\3 0003
 * @Description :
 */
@Service("devService")
public class DevServiceImpl implements DevService {

    @Resource
    private DevUserMapper devUserMapper;

    @Override
    public DevUser getUser(String devCode, String devPassword) throws Exception {
        return this.devUserMapper.getUser(devCode,devPassword);
    }
}
