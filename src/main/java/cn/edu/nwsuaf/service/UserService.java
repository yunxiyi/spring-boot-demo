package cn.edu.nwsuaf.service;

import cn.edu.nwsuaf.model.User;

import java.util.List;

/**
 * Created by huangrongchao on 2017/3/10.
 */
public interface UserService {
    List<User> findUserInfo();
    User selectByPrimaryId(long id);
}
