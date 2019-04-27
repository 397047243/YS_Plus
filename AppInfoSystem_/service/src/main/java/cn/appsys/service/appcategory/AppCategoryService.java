package cn.appsys.service.appcategory;

import cn.appsys.pojo.AppCategory;

import java.util.List;

/**
 * @author XRZ
 * @date 2019\3\4 0004
 * @Description :
 */
public interface AppCategoryService {
    /**
     * 根据分类编码模糊查询获取分类
     * @param categoryCode
     * @return
     */
    List<AppCategory> getByCode(String categoryCode) throws Exception;

    /**
     * 根据父级ID获取分类
     * @param ParentId
     * @return
     * @throws Exception
     */
    List<AppCategory> getByParentId(String ParentId) throws Exception;

    /**
     * 根据分类id获取分类名称
     * @param id
     * @return
     * @throws Exception
     */
    String getById(Integer id) throws Exception;
}
