package com.waciao.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: Waciao
 * @Date: 2020/3/30
 * @Version: 1.0
 * @Github: https://github.com/byojiaoxianz7
 */

// 登录拦截器
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 登录成功之后，应该有用户的 session
        Object loginUser = request.getSession().getAttribute("loginUser");
        if (loginUser == null) {
            // 没有登录
            request.setAttribute("msg", "没有权限，请先登录");
            // 转发到登录页面
            request.getRequestDispatcher("/").forward(request, response);
            // 不放行
            return false;
        } else {
            // 放行
            return true;
        }
    }
}
