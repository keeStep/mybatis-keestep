package org.kee.mybatis.datasource.unpooled;

import org.kee.mybatis.datasource.DataSourceFactory;
import org.kee.mybatis.reflection.MetaObject;
import org.kee.mybatis.reflection.SystemMetaObject;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @description 无池化数据源工厂
 * @author kee
 * @date 2022/10/29
 */
public class UnpooledDataSourceFactory implements DataSourceFactory {

    protected DataSource dataSource;

    public UnpooledDataSourceFactory() {
        this.dataSource = new UnpooledDataSource();
    }

    @Override
    public void setProperties(Properties props) {
        MetaObject metaObject = SystemMetaObject.forObject(dataSource);
        for (Object prop : props.keySet()) {
            String propName = (String) prop;
            // 允许set才可以set
            if (metaObject.hasSetter(propName)) {
                String value = (String) props.get(propName);
                Object convertValue = convertValue(metaObject, propName, value);

                metaObject.setValue(propName, convertValue);
            }
        }
    }

    @Override
    public DataSource getDataSource() {
        return dataSource;
    }

    /**
     * 根据setter的类型,将配置文件中的值强转成相应的类型
     * @param metaObject
     * @param propName
     * @param value
     * @return
     */
    private Object convertValue(MetaObject metaObject, String propName, String value) {
        // 目标值
        Object convertValue = value;
        // 目标值类型
        Class<?> convertType = metaObject.getSetterType(propName);

        // 强转为基本数据类型
        if (convertType == Integer.class || convertType == int.class) {
            convertValue = Integer.valueOf(value);
        }
        if (convertType == Long.class || convertType == long.class) {
            convertValue = Long.valueOf(value);
        }
        if (convertType == Boolean.class || convertType == boolean.class) {
            convertValue = Boolean.valueOf(value);
        }

        return convertValue;
    }

}
