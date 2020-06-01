package com.zsf.backup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BxlBackupApplication {

    public static void main(String[] args) {
        SpringApplication.run(BxlBackupApplication.class, args);
    }

}
