package com.dept.controller;

import com.dept.entity.Department;
import com.dept.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("departments")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department)
    {
        log.info("Inside saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/{id}")
    public Department findDepartmentById(@PathVariable("id") Long departmentId)
    {
        log.info("Inside findDepartmentById of DepartmentController");
        return departmentService.findDepartmentById(departmentId);
    }

    @GetMapping("/")
    public List<Department> findAllDepartment()
    {
        log.info("Inside findAllDepartment of DepartmentController");

        List<Department> dep = departmentService.findAllDepartment();
        dep.forEach(System.out::println);
        return dep;
    }

}

/*
         {
            "departmentName" : "IT" ,
            "departmentAddress" : "Second Floor" ,
            "departmentCode" : "IT-006"
        }

 */