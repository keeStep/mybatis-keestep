package org.kee.mybatis.transaction;

import org.kee.mybatis.session.TransactionIsolationLevel;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @description 事务工厂
 * @author kee
 * @date 2022/10/29
 */
public interface TransactionFactory {

    /**
     * 根据 Connection 创建 Transaction
     * @param conn Existing database connection
     * @return Transaction
     */
    Transaction newTransaction(Connection conn);

    /**
     * 根据数据源和事务隔离级别创建 Transaction
     * @param dataSource DataSource to take the connection from
     * @param level Desired isolation level
     * @param autoCommit Desired autocommit
     * @return Transaction
     */
    Transaction newTransaction(DataSource dataSource, TransactionIsolationLevel level, boolean autoCommit);

}
