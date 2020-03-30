package com.waciao.dao;

import com.waciao.pojo.Department;
import com.waciao.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
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

@Repository // Spring 托管
public class EmployeeDao {
    /**
     * 模拟数据库中的数据
     */
    private static Map<Integer, Employee> employeeMap = null;

    // 员工所属部门
    @Autowired
    private DepartmentDao departmentDao;

    static {
        // 创建一个员工表
        employeeMap = new HashMap<Integer, Employee>();
        employeeMap.put(1001,new Employee(1001,"A","123@qq.com",0,new Department(1,"教学部")));
        employeeMap.put(1002,new Employee(1002,"B","456@qq.com",1,new Department(2,"市场部")));
        employeeMap.put(1003,new Employee(1003,"C","789@qq.com",0,new Department(3,"教研部")));
        employeeMap.put(1004,new Employee(1004,"D","abc@qq.com",1,new Department(4,"运营部")));
        employeeMap.put(1005,new Employee(1005,"E","abc@qq.com",1,new Department(5,"小卖部")));
    }

    // 主键自增
    private static Integer initId = 1006;

    // 增加一个员工
    public void save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employeeMap.put(employee.getId(), employee);
    }

    // 查询所有员工
    public Collection<Employee> getAll() {
        return employeeMap.values();
    }

    // 根据 id 查询员工
    public Employee getEmployeeById(Integer id) {
        return employeeMap.get(id);
    }

    // 删除一个员工
    public void delete(Integer id) {
        employeeMap.remove(id);
    }
}
