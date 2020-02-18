package com.lygao.rbac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lygao
 * @create 2020-02-18 14:12
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {

    @RequestMapping(value = "/permissionPage")
    public String permissionPage(){
        return "admin/permission/permission";
    }
}
