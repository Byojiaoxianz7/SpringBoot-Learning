package com.waciao.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Waciao
 * @Date: 2020/3/30
 * @Version: 1.0
 * @Github: https://github.com/byojiaoxianz7
 */

/**
 * 部门表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    private Integer id;
    private String departmentName;
}
