package org.kee.mybatis.executor;

import org.kee.mybatis.mapping.BoundSql;
import org.kee.mybatis.mapping.MappedStatement;
import org.kee.mybatis.session.ResultHandler;
import org.kee.mybatis.transaction.Transaction;

import java.sql.SQLException;
import java.util.List;

/**
 * <p> 执行器
 *
 * @author Eric
 * @date 2022/10/29 22:40
 */
public interface Executor {

    ResultHandler NO_RESULT_HANDLER = null;

    <E> List<E> query(MappedStatement ms, Object parameter, ResultHandler resultHandler, BoundSql boundSql);

    Transaction getTransaction();

    void commit(boolean required) throws SQLException;

    void rollback(boolean required) throws SQLException;

    void close(boolean forceRollback);
}
