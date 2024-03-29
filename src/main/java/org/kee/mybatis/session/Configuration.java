package org.kee.mybatis.session;

import org.kee.mybatis.binding.MapperRegistry;
import org.kee.mybatis.datasource.druid.DruidDataSourceFactory;
import org.kee.mybatis.datasource.pooled.PooledDataSourceFactory;
import org.kee.mybatis.datasource.unpooled.UnpooledDataSourceFactory;
import org.kee.mybatis.executor.Executor;
import org.kee.mybatis.executor.SimpleExecutor;
import org.kee.mybatis.executor.resultset.ResultSetHandler;
import org.kee.mybatis.executor.statement.PreparedStatementHandler;
import org.kee.mybatis.executor.statement.StatementHandler;
import org.kee.mybatis.mapping.BoundSql;
import org.kee.mybatis.mapping.Environment;
import org.kee.mybatis.mapping.MappedStatement;
import org.kee.mybatis.transaction.Transaction;
import org.kee.mybatis.transaction.jdbc.JdbcTransactionFactory;
import org.kee.mybatis.type.TypeAliasRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @description 配置项
 * @author kee
 * @date 2022/10/29
 */
public class Configuration {

    //环境
    protected Environment environment;

    // 映射注册机
    protected MapperRegistry mapperRegistry = new MapperRegistry(this);

    // 映射的语句，存在Map里
    protected final Map<String, MappedStatement> mappedStatements = new HashMap<>();

    // 类型别名注册机
    protected final TypeAliasRegistry typeAliasRegistry = new TypeAliasRegistry();

    public Configuration() {
        typeAliasRegistry.registerAlias("JDBC", JdbcTransactionFactory.class);

        typeAliasRegistry.registerAlias("DRUID", DruidDataSourceFactory.class);
        typeAliasRegistry.registerAlias("UNPOOLED", UnpooledDataSourceFactory.class);
        typeAliasRegistry.registerAlias("POOLED", PooledDataSourceFactory.class);
    }

    public void addMappers(String packageName) {
        mapperRegistry.addMappers(packageName);
    }

    public <T> void addMapper(Class<T> type) {
        mapperRegistry.addMapper(type);
    }

    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        return mapperRegistry.getMapper(type, sqlSession);
    }

    public boolean hasMapper(Class<?> type) {
        return mapperRegistry.hasMapper(type);
    }

    public void addMappedStatement(MappedStatement ms) {
        mappedStatements.put(ms.getId(), ms);
    }

    public MappedStatement getMappedStatement(String id) {
        return mappedStatements.get(id);
    }

    public TypeAliasRegistry getTypeAliasRegistry() {
        return typeAliasRegistry;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }


    /**
     * 创建SQL执行器
     */
    public Executor newExecutor(Transaction transaction) {
        return new SimpleExecutor(this, transaction);
    }


    /**
     * 创建语句处理器
     */
    public StatementHandler newStatementHandler(Executor executor, MappedStatement mappedStatement, Object parameterObject, ResultHandler resultHandler, BoundSql boundSql) {
        return new PreparedStatementHandler(executor, mappedStatement, parameterObject, resultHandler, boundSql);
    }

    /**
     * 创建结果处理器
     */
    public ResultSetHandler newResultSetHandler(Executor executor, MappedStatement mappedStatement, BoundSql boundSql) {
        // TODO
        return null;
    }
}
