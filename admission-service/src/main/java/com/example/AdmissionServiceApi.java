package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = {"com.example.controller",
"com.example.entity", "com.example.service","com.example.repository",
        "com.example.collage.controller", "com.example"})
@EnableDiscoveryClient
public class AdmissionServiceApi {
    public static void main(String[] args) {
        SpringApplication.run(AdmissionServiceApi.class, args);
    }
}