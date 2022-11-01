package org.kee.mybatis.executor.resultset;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * <p> 结果集处理器
 *
 * @author Eric
 * @date 2022/10/30 0:33
 */
public interface ResultSetHandler {

    <E> List<E> handleResultSets(Statement statement) throws SQLException;
}
