package com.example.demo;

import com.example.demo.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class demo {

    private final UserService userService;

    public demo(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void initialize() {
        userService.initializeUsersFromCSV();
    }

    public static void main(String[] args) {
        SpringApplication.run(demo.class, args);
    }
}
