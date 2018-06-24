package com.pinyougou.manager.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
*  @Description 显示登录用户名控制器
*  @author Mr.White
*  @date 2018/6/24 9:41
*/
@RestController
public class LoginController {

    @GetMapping("/login/username")
    public Map<String,String> loginName(){
        /** 获取SecurityContext对象 */
        SecurityContext context = SecurityContextHolder.getContext();
        /** 获取当前登录用户名 */
        String loginName = context.getAuthentication().getName();
        Map<String,String> data = new HashMap<>();
        data.put("loginName",loginName);
        data.put("loginTime",new SimpleDateFormat("yyyy-MM-dd hh:mm a").format(new Date()));
        return data;
    }

}
