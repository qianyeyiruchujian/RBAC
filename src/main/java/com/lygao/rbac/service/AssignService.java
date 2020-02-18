package com.lygao.rbac.service;

import com.lygao.rbac.entity.User_Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lygao
 * @create 2020-02-17 21:18
 */
public interface AssignService {
    List<Integer> queryRoleIdByUserId(Integer userid);

    Integer insertAssign(User_Role userRole);

    Integer deleteAssign(User_Role userRole);
}
