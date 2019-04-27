package cn.xrz.tools;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @author XRZ
 * @date 2019-04-20
 * @Description : JSON工具类
 */
public class JsonUtil {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /**
     * Json字符串转JsonNode对象
     * @param str
     * @return
     */
    public static JsonNode strToJsonNode(String str){
        try {
            return OBJECT_MAPPER.readTree(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
