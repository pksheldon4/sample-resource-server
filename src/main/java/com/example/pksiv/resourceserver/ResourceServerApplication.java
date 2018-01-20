package com.example.pksiv.resourceserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ResourceServerApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(new Class[] { ResourceServerApplication.class,}, args);
    }
}