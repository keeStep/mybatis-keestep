package org.kee.mybatis.executor;

import org.kee.mybatis.executor.statement.StatementHandler;
import org.kee.mybatis.mapping.BoundSql;
import org.kee.mybatis.mapping.MappedStatement;
import org.kee.mybatis.session.Configuration;
import org.kee.mybatis.session.ResultHandler;
import org.kee.mybatis.transaction.Transaction;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

/**
 * <p>  简单执行器
 *
 * @author Eric
 * @date 2022/10/30 0:17
 */
public class SimpleExecutor extends BaseExecutor {

    public SimpleExecutor(Configuration configuration, Transaction transaction) {
        super(configuration, transaction);
    }

    @Override
    protected <E> List<E> doQuery(MappedStatement ms, Object parameter, ResultHandler resultHandler, BoundSql boundSql) {
        try {
            // 1.创建【语句处理器】
            Configuration configuration = ms.getConfiguration();
            StatementHandler statementHandler = configuration.newStatementHandler(this, ms, parameter, resultHandler, boundSql);

            // 2.获取数据源
            Connection connection = transaction.getConnection();

            // 3.语句预处理
            Statement statement = statementHandler.prepare(connection);

            // 4.参数化处理
            statementHandler.parameterize(statement);

            // 5.执行查询
            return statementHandler.query(statement, resultHandler);
        } catch (Exception e) {
            return null;
        }
    }
}
