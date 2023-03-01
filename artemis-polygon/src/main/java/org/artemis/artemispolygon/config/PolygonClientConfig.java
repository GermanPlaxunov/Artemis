package org.artemis.artemispolygon.config;

import org.artemis.artemispolygon.client.PolygonDecoder;
import org.springframework.context.annotation.Bean;

public class PolygonClientConfig {

    @Bean
    public PolygonDecoder polygonDecoder() {
        return new PolygonDecoder();
    }

}
