package cn.appsys.service.datadictionary;

import cn.appsys.pojo.DataDictionary;

import java.util.List;

/**
 * @author XRZ
 * @date 2019\3\4 0004
 * @Description :
 */
public interface DataDictionaryService {
    /**
     * 根据类型编码获取类型集合
     * @param typeCode
     * @return
     * @throws Exception
     */
    List<DataDictionary> getByTypeCode(String typeCode)throws Exception;
}
