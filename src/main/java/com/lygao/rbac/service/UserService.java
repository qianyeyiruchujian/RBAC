package com.lygao.rbac.service;

import com.lygao.rbac.entity.User;

import java.util.List;

/**
 * @author lygao
 * @create 2020-02-14 13:09
 */
public interface UserService {
    List<User> queryAllUsers(String likeFlag);

    Integer insertUser(User user);

    List<User> queryUser(User user);

    Integer updateUser(User user);

    Integer deleteUser(Integer id);

    Integer deleteUsers(List<Integer> ids);
}
