package cn.appsys.service.datadictionary;

import cn.appsys.dao.datadictionary.DataDictionaryMapper;
import cn.appsys.pojo.DataDictionary;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author XRZ
 * @date 2019\3\4 0004
 * @Description :
 */
@Service("dataDictionaryService")
public class DataDictionaryServiceImpl implements DataDictionaryService {

    @Resource
    private DataDictionaryMapper dataDictionaryMapper;

    @Override
    public List<DataDictionary> getByTypeCode(String typeCode) throws Exception {
        return this.dataDictionaryMapper.getByTypeCode(typeCode);
    }
}
