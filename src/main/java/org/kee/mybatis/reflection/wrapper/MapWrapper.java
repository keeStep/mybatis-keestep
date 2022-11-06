package org.kee.mybatis.reflection.wrapper;

import org.kee.mybatis.reflection.MetaObject;
import org.kee.mybatis.reflection.factory.ObjectFactory;
import org.kee.mybatis.reflection.property.PropertyTokenizer;

import java.util.List;
import java.util.Map;

/**
 * <p> Map 包装器
 *
 * @author Eric
 * @date 2022/11/6 22:54
 */
public class MapWrapper extends BaseWrapper {


    // 原来的对象
    private Map<String, Object> map;

    public MapWrapper(MetaObject metaObject, Map<String, Object> map) {
        super(metaObject);
        this.map = map;
    }

    @Override
    public Object get(PropertyTokenizer prop) {
        //TODO
        return null;
    }

    @Override
    public void set(PropertyTokenizer prop, Object value) {

        //TODO
    }

    @Override
    public String findProperty(String name, boolean useCamelCaseMapping) {
        return name;
    }

    @Override
    public String[] getGetterNames() {
        return map.keySet().toArray(new String[map.keySet().size()]);
    }

    @Override
    public String[] getSetterNames() {
        return map.keySet().toArray(new String[map.keySet().size()]);
    }

    @Override
    public Class<?> getSetterType(String name) {
        //TODO
        return null;
    }

    @Override
    public Class<?> getGetterType(String name) {
        //TODO
        return null;
    }

    @Override
    public boolean hasSetter(String name) {
        return true;
    }

    @Override
    public boolean hasGetter(String name) {
        //TODO
        return false;
    }

    @Override
    public MetaObject instantiatePropertyValue(String name, PropertyTokenizer prop, ObjectFactory objectFactory) {
        //TODO
        return null;
    }

    @Override
    public boolean isCollection() {
        return false;
    }

    @Override
    public void add(Object element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <E> void addAll(List<E> element) {
        throw new UnsupportedOperationException();
    }
}
