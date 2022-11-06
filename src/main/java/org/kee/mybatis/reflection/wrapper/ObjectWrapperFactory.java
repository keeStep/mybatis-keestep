package org.kee.mybatis.reflection.wrapper;

import org.kee.mybatis.reflection.MetaObject;
import org.kee.mybatis.reflection.wrapper.ObjectWrapper;

/**
 * <p> 对象包装器工厂
 *
 * @author Eric
 * @date 2022/11/6 22:48
 */
public interface ObjectWrapperFactory {

    /**
     * 判断有没有包装器
     */
    boolean hasWrapperFor(Object object);

    /**
     * 得到包装器
     */
    ObjectWrapper getWrapperFor(MetaObject metaObject, Object object);
}
