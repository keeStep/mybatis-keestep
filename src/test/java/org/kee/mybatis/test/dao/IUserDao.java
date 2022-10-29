package org.kee.mybatis.test.dao;

import org.kee.mybatis.test.po.User;

public interface IUserDao {
    User queryUserInfoById(Long uId);
}
