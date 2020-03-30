package com.waciao.config;

import com.waciao.pojo.User;
import com.waciao.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: Waciao
 * @Date: 2020/3/30
 * @Version: 1.0
 * @Github: https://github.com/byojiaoxianz7
 */

// 自定义的 UserRealm
public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    // 认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("点击'提交'按钮进入 doGetAuthenticationInfo 方法");
        UsernamePasswordToken userToken = (UsernamePasswordToken) authenticationToken;
        // 用户名，密码，数据库中取
        User user = userService.queryUserByName(userToken.getUsername());
        if (user == null) {
            // UnknownAccountException
            return null;
        }
        // 密码认证，shiro 自己做，密码加密了
        return new SimpleAuthenticationInfo("",user.getPwd(),"");
    }
}
