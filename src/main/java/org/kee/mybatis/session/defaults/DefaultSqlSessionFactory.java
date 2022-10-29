package org.kee.mybatis.session.defaults;

import org.kee.mybatis.session.Configuration;
import org.kee.mybatis.session.SqlSession;
import org.kee.mybatis.session.SqlSessionFactory;

/**
 * @description 默认的 DefaultSqlSessionFactory
 * @author kee
 * @date 2022/10/29
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }

}
