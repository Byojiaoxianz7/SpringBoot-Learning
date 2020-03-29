package com.waciao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: Waciao
 * @Date: 2020/3/29
 * @Version: 1.0
 * @Github: https://github.com/byojiaoxianz7
 */
@Controller
@RequestMapping(value = "/t1")
public class HelloController {

    /**
     * 使用 @ResponseBody 返回字符串，如果不用则找 template 下的 hello.html
     * 访问：http://localhost:8080/t1/hello
     * @return "hello"
     */
    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello";
    }


}
