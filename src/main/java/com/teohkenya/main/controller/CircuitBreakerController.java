package com.teohkenya.main.controller;

import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


/**
 * @ Author NMuchiri
 **/
@RestController
@Slf4j
public class CircuitBreakerController {



    @Retry(name = "default")
    @GetMapping("sample-api")
    public String sampleApi(){
        log.info("SAMPLE API CALL RECEIVED");
        ResponseEntity<String> responseEntity = new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url",
                String.class);

        return responseEntity.getBody();
    }
}
