package org.project.artemiscore.client;

import org.artemis.artemismodel.polygon.PolygonRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.WebUtils;

@FeignClient(name = "polygon-client", url = "${polygon.api.url}")
public interface PolygonFeignClient extends PolygonClient {

    @Override
    @PostMapping(path = "/requestPolygonData",
            consumes = MediaType.APPLICATION_JSON_VALUE + WebUtils.CONTENT_TYPE_CHARSET_PREFIX + "UTF-8",
            produces = MediaType.APPLICATION_JSON_VALUE + WebUtils.CONTENT_TYPE_CHARSET_PREFIX + "UTF-8")
    void requestPolygonData(@RequestBody PolygonRequest request);
}
