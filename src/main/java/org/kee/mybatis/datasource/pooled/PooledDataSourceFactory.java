package org.kee.mybatis.datasource.pooled;

import org.kee.mybatis.datasource.unpooled.UnpooledDataSourceFactory;

import javax.sql.DataSource;

/**
 * @description 有连接池的数据源工厂
 * @author kee
 * @date 2022/10/29
 */
public class PooledDataSourceFactory extends UnpooledDataSourceFactory {

    public PooledDataSourceFactory() {
        this.dataSource = new PooledDataSource();
    }

}
