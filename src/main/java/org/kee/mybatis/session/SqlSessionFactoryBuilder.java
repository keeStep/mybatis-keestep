package org.kee.mybatis.session;

import org.kee.mybatis.builder.xml.XMLConfigBuilder;
import org.kee.mybatis.session.defaults.DefaultSqlSessionFactory;

import java.io.Reader;

/**
 * @description 构建SqlSessionFactory的工厂
 * @author kee
 * @date 2022/10/29
 */
public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(Reader reader) {
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder(reader);
        return build(xmlConfigBuilder.parse());
    }

    public SqlSessionFactory build(Configuration config) {
        return new DefaultSqlSessionFactory(config);
    }

}
