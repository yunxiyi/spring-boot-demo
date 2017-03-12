package cn.edu.nwsuaf.service.impl;

import cn.edu.nwsuaf.dao.UserMapper;
import cn.edu.nwsuaf.model.User;
import cn.edu.nwsuaf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by huangrongchao on 2017/3/10.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> findUserInfo() {
        return userMapper.findUserInfo();
    }

    @Override
    public User selectByPrimaryId(long id) {
        return userMapper.selectByPrimaryId(id);
    }
}
