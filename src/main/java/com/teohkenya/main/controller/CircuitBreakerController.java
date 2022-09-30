package com.teohkenya.main.controller;

import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


/**
 * @ Author NMuchiri
 **/
@RestController
public class CircuitBreakerController {



    @Retry(name = "default")
    @GetMapping("sample-api")
    public String sampleApi(){

        ResponseEntity<String> responseEntity = new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url",
                String.class);

        return responseEntity.getBody();
    }
}
