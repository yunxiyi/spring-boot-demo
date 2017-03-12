package cn.edu.nwsuaf.dao;

import cn.edu.nwsuaf.model.User;

import java.util.List;

/**
 * Created by huangrongchao on 2017/3/9.
 */
public interface UserMapper {
    List<User> findUserInfo();
    User selectByPrimaryId(Long id);
}
