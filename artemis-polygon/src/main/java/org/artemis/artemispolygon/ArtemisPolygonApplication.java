package org.artemis.artemispolygon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ArtemisPolygonApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArtemisPolygonApplication.class, args);
    }
}
