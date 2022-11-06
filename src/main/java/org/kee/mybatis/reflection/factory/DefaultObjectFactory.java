package org.kee.mybatis.reflection.factory;

import java.util.List;
import java.util.Properties;

/**
 * <p>默认对象工厂，所有的对象都由工厂来生成
 *
 * @author Eric
 * @date 2022/11/6 17:50
 */
public class DefaultObjectFactory implements ObjectFactory {
    @Override
    public void setProperties(Properties properties) {

    }

    @Override
    public <T> T create(Class<T> type) {
        return null;
    }

    @Override
    public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
        return null;
    }

    @Override
    public <T> boolean isCollection(Class<T> type) {
        return false;
    }
}
