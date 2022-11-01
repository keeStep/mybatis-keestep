package org.kee.mybatis.session.defaults;

import org.kee.mybatis.executor.Executor;
import org.kee.mybatis.mapping.Environment;
import org.kee.mybatis.session.Configuration;
import org.kee.mybatis.session.SqlSession;
import org.kee.mybatis.session.SqlSessionFactory;
import org.kee.mybatis.session.TransactionIsolationLevel;
import org.kee.mybatis.transaction.Transaction;
import org.kee.mybatis.transaction.TransactionFactory;

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
        // 1.获取环境变量
        final Environment environment = configuration.getEnvironment();

        // 2.从环境变量获取事务工厂
        TransactionFactory transactionFactory = environment.getTransactionFactory();

        // 3.创建事务
        Transaction tx = transactionFactory.newTransaction(environment.getDataSource(), TransactionIsolationLevel.READ_COMMITTED, false);

        // 4.依据事务创建执行器
        final Executor executor = configuration.newExecutor(tx);

        // 5.执行器传入创建 SqlSession
        return new DefaultSqlSession(configuration, executor);
    }

}
