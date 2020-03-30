package com.waciao.config;

import org.springframework.context.annotation.Configuration;
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
     * @param registry registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 添加视图跳转，访问 /giao，会跳转到 test 页面
        // 为啥不显示数据...
        registry.addViewController("/giao").setViewName("index");
    }
}
