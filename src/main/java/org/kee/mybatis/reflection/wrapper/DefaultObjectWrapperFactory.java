package org.kee.mybatis.reflection.wrapper;

import org.kee.mybatis.reflection.MetaObject;

/**
 * <p> 默认对象包装器工厂
 *
 * @author Eric
 * @date 2022/11/6 22:49
 */
public class DefaultObjectWrapperFactory implements ObjectWrapperFactory {
    @Override
    public boolean hasWrapperFor(Object object) {
        return false;
    }

    @Override
    public ObjectWrapper getWrapperFor(MetaObject metaObject, Object object) {
        throw new RuntimeException("The DefaultObjectWrapperFactory should never be called to provide an ObjectWrapper.");
    }
}
