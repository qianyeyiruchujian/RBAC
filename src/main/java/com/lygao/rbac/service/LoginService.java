package com.lygao.rbac.service;

import com.lygao.rbac.entity.User;

/**
 * @author lygao
 * @create 2020-02-13 14:13
 */
public interface LoginService {
    User queryForLogin(User user);
}
