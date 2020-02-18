package com.lygao.rbac.mapper;

import com.lygao.rbac.entity.Role;
import com.lygao.rbac.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lygao
 * @create 2020-02-17 14:23
 */
@Repository
public interface RoleMapper {
    Integer insertRole(@Param("role") Role role);

    List<Role> queryAllRoles(String queryText);

    List<Role> queryRole(@Param("role") Role role);

    Integer updateRole(@Param("role") Role role);

    Integer deleteRole(@Param("roleid") Integer roleid);

    Integer deleteRoles(@Param("roleids")List<Integer> roleids);
}
