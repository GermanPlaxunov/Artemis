package org.project.artemisgate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ArtemisGateApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArtemisGateApplication.class, args);
    }

}
