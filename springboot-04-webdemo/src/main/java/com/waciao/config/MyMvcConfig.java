package com.waciao.config;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: Waciao
 * @Date: 2020/3/30
 * @Version: 1.0
 * @Github: https://github.com/byojiaoxianz7
 */

// 扩展 SpringMVC
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    /**
     * 视图跳转
     *
     * @param registry registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/dashboard").setViewName("dashboard");
    }

    /**
     * 拦截器以及拦截哪些请求和不拦截哪些请求
     * <p>
     * 需要过滤静态文件，不然没法显示样式
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor())
                // 拦截所有页面
                .addPathPatterns("/**")
                // 除了这些页面不拦截
                .excludePathPatterns("/", "/user/login", "/css/**", "/img/**", "/js/**");
    }
}
