package cn.appsys.service.appcategory;

import cn.appsys.dao.appcategory.AppCategoryMapper;
import cn.appsys.pojo.AppCategory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author XRZ
 * @date 2019\3\4 0004
 * @Description :
 */
@Service("appCategoryService")
public class AppCategoryServiceImpl implements AppCategoryService{

    @Resource
    private AppCategoryMapper appCategoryMapper;

    @Override
    public List<AppCategory> getByCode(String categoryCode) throws Exception {
        return this.appCategoryMapper.getByCode(categoryCode);
    }

    @Override
    public List<AppCategory> getByParentId(String ParentId) throws Exception {
        return this.appCategoryMapper.getByParentId(ParentId);
    }

    @Override
    public String getById(Integer id) throws Exception {
        return this.appCategoryMapper.getById(id);
    }
}
