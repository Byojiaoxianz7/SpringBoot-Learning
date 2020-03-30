package com.waciao.service;

import com.waciao.pojo.User;

/**
 * @Author: Waciao
 * @Date: 2020/3/30
 * @Version: 1.0
 * @Github: https://github.com/byojiaoxianz7
 */
public interface UserService {
    User queryUserByName(String name);
}
