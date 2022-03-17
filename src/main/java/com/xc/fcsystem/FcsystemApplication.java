package com.xc.fcsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class FcsystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(FcsystemApplication.class, args);
        System.out.println("run successful");
    }

}
