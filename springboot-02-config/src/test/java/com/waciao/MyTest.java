package com.waciao;

import com.waciao.pojo.Dog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author: Waciao
 * @Date: 2020/3/29
 * @Version: 1.0
 * @Github: https://github.com/byojiaoxianz7
 */
@SpringBootTest
class MyTest {


    @Autowired
    private Dog dog;

    @Test
    void test() {
        System.out.println(dog); // Reason: 不是一个合法的电子邮件地址
    }
}
