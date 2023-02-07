package com.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class UserApplication extends SpringBootServletInitializer {

    public static void main(String[] args){
        SpringApplication.run(UserApplication.class, args);
        System.out.println("Inside application");
    }

}
