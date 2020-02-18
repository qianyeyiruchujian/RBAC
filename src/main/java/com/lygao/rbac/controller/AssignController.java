package com.lygao.rbac.controller;

import com.lygao.rbac.common.AJAXResult;
import com.lygao.rbac.entity.Role;
import com.lygao.rbac.entity.User;
import com.lygao.rbac.entity.User_Role;
import com.lygao.rbac.service.AssignService;
import com.lygao.rbac.service.RoleService;
import com.lygao.rbac.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lygao
 * @create 2020-02-17 21:17
 */
@Controller
@RequestMapping("/assign")
public class AssignController {

    @Autowired
    AssignService assignService;

    @Autowired
    RoleService roleService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/goAssignPage")
    public String goAssignPage(Integer id, Model model){
        List<Integer> rolesInt = assignService.queryRoleIdByUserId(id);

        User user = new User();
        user.setId(id);
        List<User> userList = userService.queryUser(user);
        if(userList != null && userList.size() > 0){
            model.addAttribute("user",userList.get(0));
        }

        List<Role> roleList = roleService.queryAllRoles(null);
        List<Role> assignedRole = new ArrayList<>();
        List<Role> unassignRole = new ArrayList<>();
        for (Role role: roleList){
            if(rolesInt.contains(role.getRoleid())){
                assignedRole.add(role);
            }else{
                unassignRole.add(role);
            }
        }
        model.addAttribute("assignedRole",assignedRole);
        model.addAttribute("unassignRole",unassignRole);
        return "admin/user/assignRole";
    }

    @ResponseBody
    @PostMapping(value = "/addAssign")
    public Object addAssign(@RequestParam("userid")Integer userid, @RequestParam("assignedRole")Integer assignedRole){
        AJAXResult ajaxResult = new AJAXResult();
        User_Role userRole = new User_Role();
        userRole.setRoleid(assignedRole);
        userRole.setUserid(userid);
        try {
            assignService.insertAssign(userRole);
            ajaxResult.setSuccess(true);
        } catch (Exception e) {
            ajaxResult.setSuccess(false);
            e.printStackTrace();
        }
        return ajaxResult;
    }

    @ResponseBody
    @PostMapping(value = "/delAssign")
    public Object delAssign(@RequestParam("userid")Integer userid, @RequestParam("unsignRole")Integer unsignRole){
        AJAXResult ajaxResult = new AJAXResult();
        User_Role userRole = new User_Role();
        userRole.setRoleid(unsignRole);
        userRole.setUserid(userid);
        try {
            assignService.deleteAssign(userRole);
            ajaxResult.setSuccess(true);
        } catch (Exception e) {
            ajaxResult.setSuccess(false);
            e.printStackTrace();
        }
        return ajaxResult;
    }
}
