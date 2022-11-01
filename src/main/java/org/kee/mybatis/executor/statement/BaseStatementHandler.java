package org.kee.mybatis.executor.statement;

import org.kee.mybatis.executor.Executor;
import org.kee.mybatis.executor.resultset.ResultSetHandler;
import org.kee.mybatis.mapping.BoundSql;
import org.kee.mybatis.mapping.MappedStatement;
import org.kee.mybatis.session.Configuration;
import org.kee.mybatis.session.ResultHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * <p> 语句处理器抽象基类
 *
 * @author Eric
 * @date 2022/11/1 23:00
 */
public abstract class BaseStatementHandler implements StatementHandler {

    protected final Configuration configuration;
    protected final Executor executor;
    protected final MappedStatement mappedStatement;

    protected final Object parameterObject;
    protected final ResultSetHandler resultSetHandler;

    protected BoundSql boundSql;

    public BaseStatementHandler(Executor executor, MappedStatement mappedStatement, Object parameterObject, ResultHandler resultHandler, BoundSql boundSql) {
        this.configuration = mappedStatement.getConfiguration();
        this.executor = executor;
        this.mappedStatement = mappedStatement;
        this.parameterObject = parameterObject;
        this.resultSetHandler = configuration.newResultSetHandler(executor, mappedStatement, boundSql);
        this.boundSql = boundSql;
    }

    @Override
    public Statement prepare(Connection connection) throws SQLException {
        try {
            // 1.实例化 Statement
            Statement statement = instantiateStatement(connection);

            // 2.参数设置
            statement.setQueryTimeout(299);
            statement.setFetchSize(9999);

            return statement;
        } catch (Exception e) {
            throw new RuntimeException("Error preparing statement, Cause: ", e);
        }
    }

    /**
     * 实例化 Statement
     * <p>由具体语句处理器子类实现</p>
     * @param connection
     * @return
     * @throws SQLException
     */
    protected abstract Statement instantiateStatement(Connection connection) throws SQLException;
}
