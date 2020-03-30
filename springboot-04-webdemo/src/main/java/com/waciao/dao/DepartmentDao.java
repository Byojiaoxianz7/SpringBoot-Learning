package com.waciao.dao;

import com.waciao.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Waciao
 * @Date: 2020/3/30
 * @Version: 1.0
 * @Github: https://github.com/byojiaoxianz7
 */
@Repository
public class DepartmentDao {
    /**
     * 模拟数据库中的数据
     */
    private static Map<Integer, Department> departmentMap = null;

    static {
        // 创建一个部门表
        departmentMap = new HashMap<Integer, Department>();
        departmentMap.put(101, new Department(101, "教学部"));
        departmentMap.put(102, new Department(102, "市场部"));
        departmentMap.put(103, new Department(103, "教研部"));
        departmentMap.put(104, new Department(104, "运营部"));
        departmentMap.put(105, new Department(105, "小卖部"));
    }

    /**
     * 获得所有部门信息
     * @return departmentMap.values
     */
    public Collection<Department> getDepartments() {
        return departmentMap.values();
    }

    /**
     * 通过 id 获取部门
     * @param id id
     * @return departmentMap.get(id)
     */
    public Department getDepartmentById(Integer id) {
        return departmentMap.get(id);
    }

}
