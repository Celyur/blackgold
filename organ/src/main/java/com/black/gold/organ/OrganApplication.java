package com.black.gold.organ;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OrganApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrganApplication.class, args);
    }
}
