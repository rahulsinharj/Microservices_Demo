package com.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

    @GetMapping("/user-service-fall-back")
    public String userServiceFallBackMethod()
    {
        return "User-Service is taking longer than expected time." +
                "\n Please try again later !";
    }

    @GetMapping("/department-service-fall-back")
    public String departmentServiceFallBackMethod()
    {
        return "Department-Service is taking longer than expected time." +
                "\n Please try again later !";
    }
}
