package com.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrixDashboard
public class HystrixDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(HystrixDashboardApplication.class, args);

		System.out.println("HystrixDashboard Application running !");

		System.out.println("## Use this URL to see in Hystrix Dashboard, to identify which all services are running and which all services are not running = http://localhost:9295/hystrix/ ");
		System.out.println("## You can 'ping' for actuator-hystrix-stream inside Hystrix Dashboard = http://localhost:9191/actuator/hystrix.stream");


	}

}
