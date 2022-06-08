package com.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

    @GetMapping("/userServiceFallBackMethod")
    public String userServiceFallBackMethod()
    {
        return "User-Service is taking longer than expected time." +
                "\n Please try again later !";
    }

    @GetMapping("/departmentServiceFallBackMethod")
    public String departmentServiceFallBackMethod()
    {
        return "Department-Service is taking longer than expected time." +
                "\n Please try again later !";
    }
}
