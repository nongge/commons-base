package cn.pinkhorizon.commons.base.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author ybf
 * @description JavaBean和Json相互转换工具
 */
public class JsonUtils {

    private static final ObjectMapper mapper = new ObjectMapper();
    private static final TypeFactory typeFactory = mapper.getTypeFactory();

    /**
     * 将非空非String对象转成json
     */
    public static String toJson(Object obj) {
        if (obj == null || obj.getClass() == String.class) {
            throw new RuntimeException("bean to json fail");
        }
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("bean to json fail");
        }
    }

    /**
     * 将json转换成bean
     */
    public static <T> T toBean(String json, Class<T> cls) {
        try {
            return mapper.readValue(json, cls);
        } catch (IOException e) {
            throw new RuntimeException("json to bean fail, argument：" + json);
        }
    }

    /**
     * 将json转换成beanList
     */
    public static <E> List<E> toBeanList(String json, Class<E> cls) {
        try {
            return mapper.readValue(json, typeFactory.constructCollectionType(List.class, cls));
        } catch (IOException e) {
            throw new RuntimeException("json to BeanList fail, argument：" + json);
        }
    }

    /**
     * 将json转换成Map
     */
    public static <K, V> Map<K, V> toMap(String json, Class<K> kClass, Class<V> vClass) {
        try {
            return mapper.readValue(json, typeFactory.constructMapType(Map.class, kClass, vClass));
        } catch (IOException e) {
            throw new RuntimeException("json to Map fail, argument：" + json);
        }
    }

    /**
     * 将json转换多层嵌套泛型
     */
    public static <T> T nativeRead(String json, TypeReference<T> type) {
        try {
            return mapper.readValue(json, type);
        } catch (IOException e) {
            throw new RuntimeException("json to bean<T> fail, argument：" + json);
        }
    }
}