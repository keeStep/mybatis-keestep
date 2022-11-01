package org.kee.mybatis.executor.resultset;

import org.kee.mybatis.mapping.BoundSql;

import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * <p> 默认结果处理器
 *
 * @author Eric
 * @date 2022/11/1 23:36
 */
public class DefaultResultSetHandler implements ResultSetHandler {

    private final BoundSql boundSql;

    public DefaultResultSetHandler(BoundSql boundSql) {
        this.boundSql = boundSql;
    }

    @Override
    public <E> List<E> handleResultSets(Statement statement) throws SQLException {
        try {
            ResultSet resultSet = statement.getResultSet();

            return resultSet2Obj(resultSet, Class.forName(boundSql.getResultType()));
        } catch (Exception e) {
            throw new RuntimeException("DefaultResultSetHandler Error: ", e);
        }
    }

    private <E> List<E> resultSet2Obj(ResultSet resultSet, Class<?> clazz) {
        List<E> list = new ArrayList<>();
        try {
            // 1.获取结果集
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            // 每次遍历行值
            while (resultSet.next()) {
                E obj = (E) clazz.newInstance();
                for (int i = 1; i <= columnCount; i++) {
                    Object value = resultSet.getObject(i);
                    String columnName = metaData.getColumnName(i);
                    String setMethod = "set" + columnName.substring(0, 1).toUpperCase() + columnName.substring(1);
                    Method method;
                    if (value instanceof Timestamp) {
                        method = clazz.getMethod(setMethod, Date.class);
                    } else {
                        method = clazz.getMethod(setMethod, value.getClass());
                    }
                    method.invoke(obj, value);
                }
                list.add(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
