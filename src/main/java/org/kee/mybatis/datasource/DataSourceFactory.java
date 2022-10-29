package org.kee.mybatis.datasource;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @description 数据源工厂
 * @author kee
 * @date 2022/10/29
 */
public interface DataSourceFactory {

    void setProperties(Properties props);

    DataSource getDataSource();

}
