package org.kee.mybatis.session.defaults;

import org.kee.mybatis.executor.Executor;
import org.kee.mybatis.mapping.BoundSql;
import org.kee.mybatis.mapping.Environment;
import org.kee.mybatis.mapping.MappedStatement;
import org.kee.mybatis.session.Configuration;
import org.kee.mybatis.session.SqlSession;

import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @description 默认SqlSession实现类
 * @author kee
 * @date 2022/10/29
 */
public class DefaultSqlSession implements SqlSession {

    private Configuration configuration;
    private Executor executor;

    public DefaultSqlSession(Configuration configuration, Executor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    @Override
    public <T> T selectOne(String statement) {
        return this.selectOne(statement);
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        MappedStatement ms = configuration.getMappedStatement(statement);

        List<T> objList = executor.query(ms, parameter, Executor.NO_RESULT_HANDLER, ms.getBoundSql());
        return objList.get(0);
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return configuration.getMapper(type, this);
    }

    @Override
    public Configuration getConfiguration() {
        return configuration;
    }

}
