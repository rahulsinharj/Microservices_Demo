package com.dept.service;

import com.dept.entity.Department;
import com.dept.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department)
    {
        log.info("Inside saveDepartment of DepartmentService");
        return departmentRepository.save(department);
    }

    public Department findDepartmentById(Long departmentId)
    {
        log.info("Inside findDepartmentById of DepartmentService");
        return departmentRepository.findById(departmentId).get();

    }

    public List<Department> findAllDepartment()
    {
        return departmentRepository.findAll();
    }
}
