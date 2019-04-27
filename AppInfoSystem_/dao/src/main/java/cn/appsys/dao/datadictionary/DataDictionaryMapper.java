package cn.appsys.dao.datadictionary;

import cn.appsys.pojo.DataDictionary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author XRZ
 * @date 2019\3\4 0004
 * @Description :
 */
public interface DataDictionaryMapper {

    /**
     * 根据类型编码获取类型集合
     * @param typeCode
     * @return
     * @throws Exception
     */
    List<DataDictionary> getByTypeCode(@Param("typeCode") String typeCode)throws Exception;
}
