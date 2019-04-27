package cn.appsys.service.appinfo;

import cn.appsys.dao.appinfo.AppInfoMapper;
import cn.appsys.dao.appsersion.AppVersionMapper;
import cn.appsys.pojo.AppInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author XRZ
 * @date 2019\3\4 0004
 * @Description :
 */
@Service("appInfoService")
public class AppInfoServiceImpl implements AppInfoService{

    @Resource
    private AppInfoMapper appInfoMapper;
    @Resource
    private AppVersionMapper appVersionMapper;

    @Override
    public List<AppInfo> getList(AppInfo appInfo) throws Exception {
        return this.appInfoMapper.getList(appInfo);
    }

    @Override
    public Integer isAPKName(String APKName) throws Exception{
        return  this.appInfoMapper.isAPKName(APKName);
    }

    @Override
    public Integer addAppInfo(AppInfo appInfo) throws Exception {
        return this.appInfoMapper.addAppInfo(appInfo);
    }

    @Override
    public AppInfo getById(String id) throws Exception {
        return this.appInfoMapper.getById(id);
    }

    @Transactional
    @Override
    public int delById(String id) throws Exception {
        this.appVersionMapper.delByAppId(id); //删除版本号
        return this.appInfoMapper.delById(id); //删除应用信息
    }

    @Override
    public int delByIdFile(String id) throws Exception {
        return this.appInfoMapper.delByIdFile(id);
    }

    @Override
    public int updateAppInfo(AppInfo appInfo) throws Exception {
        return this.appInfoMapper.updateAppInfo(appInfo);
    }

    @Override
    public int updateSatus(Integer status, String id) throws Exception {
        return this.appInfoMapper.updateSatus(status,id);
    }

    @Override
    public int updateVersion(Integer pid, Integer vid) throws Exception {
        return this.appInfoMapper.updateVersion(pid,vid);
    }
}
