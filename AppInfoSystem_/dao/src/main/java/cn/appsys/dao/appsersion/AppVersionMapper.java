package cn.appsys.dao.appsersion;

import cn.appsys.pojo.AppVersion;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author XRZ
 * @date 2019\3\5 0005
 * @Description :
 */
public interface AppVersionMapper {

    /**
     * 根据APPID获取版本集合
     * @param id
     * @return
     * @throws Exception
     */
    List<AppVersion> getByAppId(@Param("id") String id) throws Exception;

    /**
     * 根据APPId删除版本信息
     * @param id
     * @return
     * @throws Exception
     */
    int delByAppId(@Param("id") String id)throws Exception;

    /**
     * 根据ID删除路径信息
     * @param id
     * @return
     * @throws Exception
     */
    int delFile(@Param("id") String id)throws Exception;

    /**
     * 根据ID获取版本信息
     * @param id
     * @return
     * @throws Exception
     */
    AppVersion getById(@Param("id") String id) throws Exception;

    /**
     * 添加版本信息
     * @param appVersion
     * @return
     * @throws Exception
     */
    int add(AppVersion appVersion) throws Exception;

    /**
     * 修改版本号
     * @param appVersion
     * @return
     * @throws Exception
     */
    int update(AppVersion appVersion)throws Exception;
}
