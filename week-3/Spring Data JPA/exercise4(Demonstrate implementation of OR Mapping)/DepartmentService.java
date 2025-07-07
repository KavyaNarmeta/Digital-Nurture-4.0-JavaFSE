package com.cognizant.orm_learn.service;

import com.cognizant.orm_learn.model.Department;
import com.cognizant.orm_learn.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Transactional
    public void displayDepartmentWithEmployees() {
        List<Department> departments = departmentRepository.findAll();

        for (Department dept : departments) {
            System.out.println("Department: " + dept.getName());
            for (var emp : dept.getEmployeeList()) {
                System.out.println("  - Employee: " + emp.getName());
            }
        }
    }
}
