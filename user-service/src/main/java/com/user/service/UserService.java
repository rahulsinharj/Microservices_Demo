package com.user.service;

import com.user.VO.Department;
import com.user.VO.ResponseTemplateVO;
import com.user.entity.User;
import com.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user)
    {
        log.info("Inside saveUser of UserService");
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId)
    {
        log.info("Inside getUserWithDepartment of UserService");
        ResponseTemplateVO vo = new ResponseTemplateVO();

        User user = userRepository.findById(userId).get();
        System.out.println("user : "+user);

        // Now for getting the department object, we need to take help from RestTemplate obj
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" +user.getDepartmentId(), Department.class);

        /* Since we have registered our user-server (localhost:9002) with name as "USER-SERVICE"  inside our Eureka-Service-Registry(8761)
                            And,  department-server (localhost:9001) with name as "DEPARTMENT-SERVICE"    inside our Eureka-Service-Registry(8761)
            Therefore now, we no need to bother about 'HOST' and 'PORT' of any microservice,
            Means, we can use the registered name "DEPARTMENT-SERVICE" in place of "localhost:9001"
                http://localhost:9001/departments/    =>  http://DEPARTMENT-SERVICE/departments/

         # Also, actually also the RestTemplate Bean need to annotated with @LoadBalanced, to indicated that it is client side load balanced.

        */
        System.out.println("department : "+department);

        vo.setUser(user);
        vo.setDepartment(department);

        return vo;
    }
}
