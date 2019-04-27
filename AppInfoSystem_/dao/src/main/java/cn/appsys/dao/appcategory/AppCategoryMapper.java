package cn.appsys.dao.appcategory;

import cn.appsys.pojo.AppCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author XRZ
 * @date 2019\3\4 0004
 * @Description :
 */
public interface AppCategoryMapper {

    /**
     * 根据分类编码模糊查询获取分类
     * @param categoryCode
     * @return
     */
    List<AppCategory> getByCode(@Param("categoryCode") String categoryCode) throws Exception;

    /**
     * 根据父级ID获取分类
     * @param ParentId
     * @return
     * @throws Exception
     */
    List<AppCategory> getByParentId(@Param("parentId") String ParentId) throws Exception;

    /**
     * 根据分类id获取分类名称
     * @param id
     * @return
     * @throws Exception
     */
    String getById(@Param("id") Integer id) throws Exception;
}
