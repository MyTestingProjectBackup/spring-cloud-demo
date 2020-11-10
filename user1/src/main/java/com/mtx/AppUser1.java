package com.mtx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AppUser1 {

    public static void main(String[] args) {

        SpringApplication.run(AppUser1.class);
    }
}
