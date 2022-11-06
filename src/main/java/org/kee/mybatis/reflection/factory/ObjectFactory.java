package org.kee.mybatis.reflection.factory;

import java.util.List;
import java.util.Properties;

/**
 * <p> 对象工厂接口
 *
 * @author Eric
 * @date 2022/11/6 17:45
 */
public interface ObjectFactory {

    /**
     * 设置属性
     * @param properties
     */
    void setProperties(Properties properties);

    /**
     * 生产对象
     * @param type
     * @param <T>
     * @return
     */
    <T> T create(Class<T> type);


    /**
     * 生产对象（使用构造函数和构造函数参数）
     * @param type
     * @param constructorArgTypes
     * @param constructorArgs
     * @param <T>
     * @return
     */
    <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs);

    /**
     * 是否集合
     * @param type
     * @param <T>
     * @return
     */
    <T> boolean isCollection(Class<T> type);
}
