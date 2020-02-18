package com.lygao.rbac.mapper;

import com.lygao.rbac.entity.User_Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lygao
 * @create 2020-02-17 21:19
 */
@Repository
public interface AssignMapper {
    List<Integer> queryRoleIdByUserId(@Param("userid") Integer userid);

    Integer insertAssign(@Param("userRole") User_Role userRole);

    Integer deleteAssign(@Param("userRole") User_Role userRole);
}
