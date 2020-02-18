package com.lygao.rbac.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lygao.rbac.common.AJAXResult;
import com.lygao.rbac.entity.User;
import com.lygao.rbac.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

/**
 * @author lygao
 * @create 2020-02-14 13:08
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @ResponseBody
    @PostMapping(value = "/userList")
    public Object userPage(Integer pageNum, Integer pageSize, String queryText){
        PageHelper.startPage(pageNum,pageSize,"createtime,modifytime desc");
        List<User> userList = userService.queryAllUsers(queryText);
        AJAXResult<User> ajaxResult = new AJAXResult<>();
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        if(pageInfo != null){
            ajaxResult.setSuccess(true);
            ajaxResult.setPageInfo(pageInfo);
        }else{
            ajaxResult.setSuccess(false);
        }
        return ajaxResult;
    }

    @GetMapping(value = "/userPage")
    public String userPage(){
        return "admin/user/user";
    }

    @GetMapping(value = "/addUserPage")
    public String addUserPage(){
        return "admin/user/add";
    }

    @ResponseBody
    @PostMapping(value = "/addUser")
    public Object addUser(User user){
        AJAXResult ajaxResult = new AJAXResult();
        user.setDuty("member");
        user.setPassword("123456");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        user.setCreatetime(LocalDateTime.now().format(dateTimeFormatter));
        user.setModifytime(LocalDateTime.now().format(dateTimeFormatter));
        Integer integer = userService.insertUser(user);
        if(integer > 0){
            ajaxResult.setSuccess(true);
        }else{
            ajaxResult.setSuccess(false);
        }
        return ajaxResult;
    }

    @RequestMapping("/editUserPage")
    public String editUserPage(Integer id, Model model){
        User user = new User();
        user.setId(id);
        List<User> userList = userService.queryUser(user);
        if(userList.size()>0){
            model.addAttribute("user",userList.get(0));
        }
        return "admin/user/edit";
    }

    @ResponseBody
    @PostMapping("/updateUser")
    public Object updateUser(User user){
        AJAXResult ajaxResult = new AJAXResult();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        user.setModifytime(LocalDateTime.now().format(dateTimeFormatter));
        Integer integer = userService.updateUser(user);
        if(integer > 0){
            ajaxResult.setSuccess(true);
        }else{
            ajaxResult.setSuccess(false);
        }
        return ajaxResult;
    }

    @ResponseBody
    @PostMapping(value = "/deleteUser")
    public Object deleteUser(Integer id){
        AJAXResult ajaxResult = new AJAXResult();
        Integer integer = userService.deleteUser(id);
        if(integer > 0){
            ajaxResult.setSuccess(true);
        }else{
            ajaxResult.setSuccess(false);
        }
        return ajaxResult;
    }

    @ResponseBody
    @RequestMapping(value = "/deleteUsers")
    public Object deleteUsers(Integer[] userid){
        AJAXResult ajaxResult = new AJAXResult();
        try {
            userService.deleteUsers(Arrays.asList(userid));
            ajaxResult.setSuccess(true);
        } catch (Exception e) {
            ajaxResult.setSuccess(false);
            e.printStackTrace();
        }
        return ajaxResult;
    }

}
