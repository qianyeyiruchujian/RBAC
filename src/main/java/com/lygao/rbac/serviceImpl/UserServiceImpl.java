package com.lygao.rbac.serviceImpl;

import com.lygao.rbac.entity.User;
import com.lygao.rbac.mapper.UserMapper;
import com.lygao.rbac.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author lygao
 * @create 2020-02-14 13:09
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> queryAllUsers(String queryText) {
        return userMapper.queryAllUsers(queryText);
    }

    @Override
    @Transactional
    public Integer insertUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public List<User> queryUser(User user) {
        return userMapper.queryUser(user);
    }

    @Override
    @Transactional
    public Integer updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    @Transactional
    public Integer deleteUser(Integer id) {
        return userMapper.deleteUser(id);
    }

    @Override
    @Transactional
    public Integer deleteUsers(List<Integer> ids) {
        return userMapper.deleteUsers(ids);
    }


}
