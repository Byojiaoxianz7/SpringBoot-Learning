package com.waciao.mapper;

import com.waciao.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Author: Waciao
 * @Date: 2020/3/30
 * @Version: 1.0
 * @Github: https://github.com/byojiaoxianz7
 */

@Mapper
@Repository
public interface UserMapper {
    User queryUserByName(String name);
}
