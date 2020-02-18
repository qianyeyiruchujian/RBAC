package com.lygao.rbac.service;

import com.lygao.rbac.entity.Role;

import java.util.List;

/**
 * @author lygao
 * @create 2020-02-17 14:24
 */
public interface RoleService {
    Integer insertRole(Role role);

    List<Role> queryAllRoles(String queryText);

    List<Role> queryRole(Role role);

    Integer updateRole(Role role);

    Integer deleteRole(Integer roleid);

    Integer deleteRoles(List<Integer> roleids);
}
