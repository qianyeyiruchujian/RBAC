package com.lygao.rbac.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lygao.rbac.common.AJAXResult;
import com.lygao.rbac.entity.Role;
import com.lygao.rbac.service.RoleService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

/**
 * @author lygao
 * @create 2020-02-17 14:23
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @RequestMapping(value = "/rolePage")
    public String rolePage(){
        return "admin/role/role";
    }

    @RequestMapping(value = "/addRolePage")
    public Object addRolePage(){
        return "admin/role/add";
    }

    @ResponseBody
    @PostMapping(value = "/addRole")
    public Object addRole(Role role){
        AJAXResult result = new AJAXResult();
        try {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
            role.setCreatetime(LocalDateTime.now().format(dateTimeFormatter));
            role.setModifytime(LocalDateTime.now().format(dateTimeFormatter));
            roleService.insertRole(role);
            result.setSuccess(true);
        } catch (Exception e) {
            result.setSuccess(false);
            e.printStackTrace();
        }
        return result;
    }

    @ResponseBody
    @PostMapping(value = "/roleList")
    public Object roleList(Integer pageNum, Integer pageSize, String queryText){
        AJAXResult<Role> ajaxResult = new AJAXResult<>();
        PageHelper.startPage(pageNum,pageSize,"createtime,modifytime desc");
        List<Role> roleList = roleService.queryAllRoles(queryText);
        PageInfo<Role> pageInfo = new PageInfo<>(roleList);
        if(pageInfo != null){
            ajaxResult.setPageInfo(pageInfo);
            ajaxResult.setSuccess(true);
        }else{
            ajaxResult.setSuccess(false);
        }
        return ajaxResult;
    }

    @GetMapping(value = "/editRolePage")
    public String editRolePage(Role role, Model model){
        List<Role> roleList = roleService.queryRole(role);
        if(roleList != null && roleList.size() > 0){
            model.addAttribute("role",roleList.get(0));
        }
        return "admin/role/edit";
    }

    @ResponseBody
    @RequestMapping(value = "/updateRole")
    public Object updateRole(Role role){
        AJAXResult<Role> ajaxResult = new AJAXResult<>();
        try {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
            role.setModifytime(LocalDateTime.now().format(dateTimeFormatter));
            roleService.updateRole(role);
            ajaxResult.setSuccess(true);
        } catch (Exception e) {
            ajaxResult.setSuccess(false);
            e.printStackTrace();
        }
        return ajaxResult;
    }

    @ResponseBody
    @RequestMapping(value = "/deleteRole")
    public Object deleteRole(Integer roleid){
        AJAXResult ajaxResult = new AJAXResult();
        try {
            roleService.deleteRole(roleid);
            ajaxResult.setSuccess(true);
        } catch (Exception e) {
            ajaxResult.setSuccess(false);
            e.printStackTrace();
        }
        return ajaxResult;
    }

    @ResponseBody
    @RequestMapping(value = "/deleteRoles")
    public Object deleteRoles(Integer[] roleid){
        AJAXResult ajaxResult = new AJAXResult();
        try {
            roleService.deleteRoles(Arrays.asList(roleid));
            ajaxResult.setSuccess(true);
        } catch (Exception e) {
            ajaxResult.setSuccess(false);
            e.printStackTrace();
        }
        return ajaxResult;
    }
}
