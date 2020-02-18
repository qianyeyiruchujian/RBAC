package com.lygao.rbac.serviceImpl;

import com.lygao.rbac.entity.User;
import com.lygao.rbac.mapper.LoginMapper;
import com.lygao.rbac.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lygao
 * @create 2020-02-13 14:13
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginMapper loginMapper;

    @Override
    public User queryForLogin(User user) {
        return loginMapper.queryForLogin(user);
    }
}
