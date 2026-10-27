package com.dohieuhien.ojt.hieuhien_developingcrud_lab1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class HieuHienDevelopingCrudLab1Application {

    public static void main(String[] args) {
        SpringApplication.run(HieuHienDevelopingCrudLab1Application.class, args);
    }

}
