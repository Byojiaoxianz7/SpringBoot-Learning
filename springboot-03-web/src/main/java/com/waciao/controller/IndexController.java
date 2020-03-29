package com.waciao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: Waciao
 * @Date: 2020/3/29
 * @Version: 1.0
 * @Github: https://github.com/byojiaoxianz7
 */

/**
 * 使用 @RestController 就不用跳视图了
 * @Controller 跳转到视图
 * 需要模板引擎支持才能生效（thymeleaf/freemarker/...)
 * 不然会报 404 错误
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("msg", "一gi我里giaogiao！！");
        return "index";
    }
}
