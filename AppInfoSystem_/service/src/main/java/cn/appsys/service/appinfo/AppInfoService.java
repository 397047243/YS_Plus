package cn.appsys.service.appinfo;

import cn.appsys.pojo.AppInfo;

import java.util.List;

/**
 * @author XRZ
 * @date 2019\3\4 0004
 * @Description :
 */
public interface AppInfoService {

    /**
     * 获取Appinfo集合
     * @param appInfo
     * @return
     * @throws Exception
     */
    List<AppInfo> getList(AppInfo appInfo) throws Exception;


    /**
     * 查询APKName是否存在
     * @param APKName
     * @return
     */
    Integer isAPKName(String APKName) throws Exception;

    /**
     * 添加APP信息
     * @param appInfo
     * @return
     * @throws Exception
     */
    Integer addAppInfo(AppInfo appInfo) throws Exception;

    /**
     *  根据ID获取APP信息
     * @param id
     * @return
     */
    AppInfo getById(String id) throws Exception;

    /**
     * 根据APPId删除版本信息
     * @param id
     * @return
     * @throws Exception
     */
    int delById(String id)throws Exception;

    /**
     * 根据ID删除图片路径
     * @param id
     * @return
     * @throws Exception
     */
    int delByIdFile(String id) throws Exception;

    /**
     * 更新AppInfo
     * @param appInfo
     * @return
     * @throws Exception
     */
    int updateAppInfo(AppInfo appInfo) throws Exception;

    /**
     * 根据ID修改状态
     * @param status
     * @param id
     * @return
     */
    int updateSatus(Integer status, String id) throws Exception;

    /**
     * 根据ID修改版本号
     * @param pid
     * @return
     * @throws Exception
     */
    int updateVersion(Integer pid, Integer vid) throws Exception;
}
