package com.lygao.rbac.mapper;

import com.lygao.rbac.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author lygao
 * @create 2020-02-13 14:13
 */
@Repository
public interface LoginMapper {
    User queryForLogin(@Param("User")User user);
}
