package org.kee.mybatis.session;

/**
 * @description 工厂模式接口，构建SqlSession的工厂
 * @author kee
 * @date 2022/10/29
 */
public interface SqlSessionFactory {

    /**
     * 打开一个 session
     * @return SqlSession
     */
   SqlSession openSession();

}
