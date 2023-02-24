package org.artemis.artemispolygon.client;

import feign.FeignException;
import feign.Response;
import feign.codec.Decoder;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.stream.Collectors;

@Slf4j
public class PolygonDecoder implements Decoder {
    @Override
    public Object decode(Response response, Type type) throws IOException, FeignException {
        try (var reader = response.body().asReader();
             var buffered = new BufferedReader(reader)) {
            var text = buffered.lines()
                    .collect(Collectors.joining());
            log.info("Response: {}", text);
            return text;
        }
    }
}
