package com.lygao.rbac.serviceImpl;

import com.lygao.rbac.entity.Role;
import com.lygao.rbac.mapper.RoleMapper;
import com.lygao.rbac.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author lygao
 * @create 2020-02-17 14:24
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleMapper roleMapper;

    @Override
    @Transactional
    public Integer insertRole(Role role) {
        return roleMapper.insertRole(role);
    }

    @Override
    public List<Role> queryAllRoles(String queryText) {
        return roleMapper.queryAllRoles(queryText);
    }

    @Override
    public List<Role> queryRole(Role role) {
        return roleMapper.queryRole(role);
    }

    @Override
    @Transactional
    public Integer updateRole(Role role) {
        return roleMapper.updateRole(role);
    }

    @Override
    @Transactional
    public Integer deleteRole(Integer roleid) {
        return roleMapper.deleteRole(roleid);
    }

    @Override
    @Transactional
    public Integer deleteRoles(List<Integer> roleids) {
        return roleMapper.deleteRoles(roleids);
    }
}
