package org.kee.mybatis.executor.statement;

import org.kee.mybatis.executor.Executor;
import org.kee.mybatis.executor.resultset.ResultSetHandler;
import org.kee.mybatis.mapping.BoundSql;
import org.kee.mybatis.mapping.MappedStatement;
import org.kee.mybatis.session.ResultHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * <p> 简单语句处理器
 *
 * @author Eric
 * @date 2022/11/1 23:10
 */
public class SimpleStatementHandler extends BaseStatementHandler {


    public SimpleStatementHandler(Executor executor, MappedStatement mappedStatement, Object parameterObject, ResultSetHandler resultSetHandler, BoundSql boundSql) {
        super(executor, mappedStatement, parameterObject, resultSetHandler, boundSql);
    }

    @Override
    protected Statement instantiateStatement(Connection connection) throws SQLException {
        // TODO 简单与预处理的 Statement 实例化有何不同
        return connection.createStatement();
    }

    @Override
    public void parameterize(Statement statement) throws SQLException {
        // 简单语句处理器不做参数化处理
    }

    @Override
    public <E> List<E> query(Statement statement, ResultHandler resultHandler) throws SQLException {
        String sql = boundSql.getSql();
        statement.execute(sql);
        return this.resultHandler.handleResultSets(statement);
    }
}
