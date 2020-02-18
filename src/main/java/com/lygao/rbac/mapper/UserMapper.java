package com.lygao.rbac.mapper;

import com.lygao.rbac.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lygao
 * @create 2020-02-14 13:09
 */
@Repository
public interface UserMapper {
    List<User> queryAllUsers(String queryText);

    Integer insertUser(@Param("user") User user);

    List<User> queryUser(@Param("user") User user);

    Integer updateUser(@Param("user") User user);

    Integer deleteUser(Integer id);

    Integer deleteUsers(@Param("ids") List<Integer> ids);
}
