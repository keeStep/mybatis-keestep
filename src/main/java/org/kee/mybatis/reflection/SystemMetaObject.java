package org.kee.mybatis.reflection;

import org.kee.mybatis.reflection.factory.DefaultObjectFactory;
import org.kee.mybatis.reflection.factory.ObjectFactory;
import org.kee.mybatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.kee.mybatis.reflection.wrapper.ObjectWrapperFactory;

/**
 * <p> 系统级元对象
 *
 * @author Eric
 * @date 2022/11/6 22:47
 */
public class SystemMetaObject {

    public static final ObjectFactory DEFAULT_OBJECT_FACTORY = new DefaultObjectFactory();
    public static final ObjectWrapperFactory DEFAULT_OBJECT_WRAPPER_FACTORY = new DefaultObjectWrapperFactory();
    public static final MetaObject NULL_META_OBJECT = MetaObject.forObject(NullObject.class, DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY);

    private SystemMetaObject() {
        // Prevent Instantiation of Static Class
    }

    /**
     * 空对象
     */
    private static class NullObject {
    }

    public static MetaObject forObject(Object object) {
        return MetaObject.forObject(object, DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY);
    }
}
