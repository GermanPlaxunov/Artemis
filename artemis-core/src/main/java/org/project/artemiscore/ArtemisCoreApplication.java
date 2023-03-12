package org.project.artemiscore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ArtemisCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArtemisCoreApplication.class, args);
    }

}
