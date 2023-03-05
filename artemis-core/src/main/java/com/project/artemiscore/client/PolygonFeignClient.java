package com.project.artemiscore.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "polygon-client", url = "http://localhost:8082/polygon")
public interface PolygonFeignClient {
}
