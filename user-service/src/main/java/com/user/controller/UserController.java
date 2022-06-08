package com.user.controller;

import com.user.VO.ResponseTemplateVO;
import com.user.entity.User;
import com.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
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
    public ResponseEntity<?> getUserWithDepartment(@PathVariable("id") Long userId)
    {
        log.info("Inside getUserWithDepartment of UserController");
        ResponseTemplateVO vo = null;
        try{
            vo = userService.getUserWithDepartment(userId);
            return new ResponseEntity<>(vo, HttpStatus.OK);
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No Used found, check again !");
        }


    }

}

/*
            {   "firstName" : "Shashank",
                "lastName" : "Kumar",
                "email" : "shashank@gmail.com",
                "departmentId" : 2
            }

 */
