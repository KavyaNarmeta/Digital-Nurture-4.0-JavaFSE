package com.cognizant.springlearn.dao;

import com.cognizant.springlearn.model.Department;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class DepartmentDao {
    public static List<Department> DEPARTMENT_LIST;

    public DepartmentDao() {
        ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
        DEPARTMENT_LIST = context.getBean("departmentList", List.class);
    }

    public List<Department> getAllDepartments() {
        return DEPARTMENT_LIST;
    }
}
