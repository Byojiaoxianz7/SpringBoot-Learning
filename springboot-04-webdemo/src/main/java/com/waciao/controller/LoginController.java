package com.waciao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @Author: Waciao
 * @Date: 2020/3/30
 * @Version: 1.0
 * @Github: https://github.com/byojiaoxianz7
 */
@Controller
public class LoginController {

    @RequestMapping("user/login")
    public String login(@RequestParam(value = "username") String username,
                        @RequestParam(value = "password") String password,
                        Model model,
                        HttpSession session) {

        // 判断用户密码
        // 用户名不为空且密码为 1
        if (!StringUtils.isEmpty(username) && "1".equals(password)) {
            // 设置 session
            session.setAttribute("loginUser", username);
            // 防止表单重复提交，使用重定向
            return "redirect:/dashboard";
        } else {
            model.addAttribute("msg", "用户名或密码错误");
            return "index";
        }
    }

    @RequestMapping("/user/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
