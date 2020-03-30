package com.waciao.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: Waciao
 * @Date: 2020/3/30
 * @Version: 1.0
 * @Github: https://github.com/byojiaoxianz7
 */

@Controller
public class IndexController {
    /**
     * Subject:             角色
     * SecurityManager:     管理所有角色
     * Realm:               连接数据
     */

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("msg", "Hello shiro");
        return "index";
    }

    @RequestMapping("/user/add")
    public String add() {
        return "add";
    }

    @RequestMapping("/user/update")
    public String update() {
        return "update";
    }

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/login")
    public String login(String username, String password, Model model) {
        // 获取当前的用户
        Subject subject = SecurityUtils.getSubject();
        // 封装用户的登录数据
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
        try {
            // 执行登录的方法，如果没有异常就登录成功了，跳转到主页面
            subject.login(usernamePasswordToken);
            return "index";
        } catch (UnknownAccountException | IncorrectCredentialsException e) {  // 用户名或密码不存在
            model.addAttribute("msg", "用户名或密码错误");
            return "login";
        }

    }
}
