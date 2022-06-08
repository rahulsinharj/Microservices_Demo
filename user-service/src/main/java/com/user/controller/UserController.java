package com.user.controller;

import com.user.VO.ResponseTemplateVO;
import com.user.entity.User;
import com.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user)
    {
        log.info("Inside saveUser of UserController");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId)
    {
        log.info("Inside getUserWithDepartment of UserController");
        return userService.getUserWithDepartment(userId);
    }

}

/*
            {   "firstName" : "Shashank",
                "lastName" : "Kumar",
                "email" : "shashank@gmail.com",
                "departmentId" : 2
            }

 */
