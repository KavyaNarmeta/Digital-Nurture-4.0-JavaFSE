package com.cognizant.springlearn.service;

import com.cognizant.springlearn.dao.DepartmentDao;
import com.cognizant.springlearn.model.Department;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    private DepartmentDao departmentDao = new DepartmentDao();

    public List<Department> getAllDepartments() {
        return departmentDao.getAllDepartments();
    }
}
