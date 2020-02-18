package com.lygao.rbac.controller;

import com.lygao.rbac.common.AJAXResult;
import com.lygao.rbac.entity.User;
import com.lygao.rbac.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author lygao
 * @create 2020-02-13 12:44
 */
@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    @GetMapping(value = "/login")
    public String login(){
        return "login";
    }

    @ResponseBody
    @PostMapping(value = "/doLogin")
    public Object doLogin(User user, HttpSession session){
        AJAXResult ajaxResult = new AJAXResult();
        User dbUser = loginService.queryForLogin(user);
        if(dbUser != null){
            session.setAttribute("User",dbUser);
            ajaxResult.setSuccess(true);
        }else{
            ajaxResult.setSuccess(false);
        }
        return ajaxResult;
    }

    @GetMapping(value = "/main")
    public String main(){
        return "admin/main";
    }

    @GetMapping(value = "/logout")
    public String logout(HttpSession session){
        //session.removeAttribute("User");
        session.invalidate();//使session失效
        return "redirect:login";
    }
}
