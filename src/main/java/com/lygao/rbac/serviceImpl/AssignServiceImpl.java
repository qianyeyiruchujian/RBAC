package com.lygao.rbac.serviceImpl;

import com.lygao.rbac.entity.User_Role;
import com.lygao.rbac.mapper.AssignMapper;
import com.lygao.rbac.service.AssignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author lygao
 * @create 2020-02-17 21:18
 */
@Service
public class AssignServiceImpl implements AssignService {

    @Autowired
    AssignMapper assignMapper;

    @Override
    public List<Integer> queryRoleIdByUserId(Integer userid) {
        return assignMapper.queryRoleIdByUserId(userid);
    }

    @Override
    @Transactional
    public Integer insertAssign(User_Role userRole) {
        return assignMapper.insertAssign(userRole);
    }

    @Override
    @Transactional
    public Integer deleteAssign(User_Role userRole) {
        return assignMapper.deleteAssign(userRole);
    }


}
