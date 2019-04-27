package cn.appsys.service.appsersion;

import cn.appsys.dao.appsersion.AppVersionMapper;
import cn.appsys.pojo.AppVersion;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author XRZ
 * @date 2019\3\5 0005
 * @Description :
 */
@Service("appVersionService")
public class AppVersionServiceImpl implements AppVersionService{

    @Resource
    private AppVersionMapper appVersionMapper;

    @Override
    public List<AppVersion> getByAppId(String id) throws Exception {
        return this.appVersionMapper.getByAppId(id);
    }

    @Override
    public int delByAppId(String id) throws Exception {
        return this.appVersionMapper.delByAppId(id);
    }

    @Override
    public int delFile(String id) throws Exception {
        return this.appVersionMapper.delFile(id);
    }

    @Override
    public AppVersion getById(String id) throws Exception {
        return this.appVersionMapper.getById(id);
    }

    @Override
    public int add(AppVersion appVersion) throws Exception {
        return this.appVersionMapper.add(appVersion);
    }

    @Override
    public int update(AppVersion appVersion) throws Exception {
        return this.appVersionMapper.update(appVersion);
    }
}
