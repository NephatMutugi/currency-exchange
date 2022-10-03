package com.teohkenya.main.controller;

import com.teohkenya.main.model.Error;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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



    @Retry(name = "sample-api", fallbackMethod = "errorResponse")
    @GetMapping("sample-api")
    public ResponseEntity<?> sampleApi(){
        log.info("SAMPLE API CALL RECEIVED");
        ResponseEntity<String> responseEntity = new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url",
                String.class);

        return new ResponseEntity<>(responseEntity.getBody(), HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<?> errorResponse(Exception ex){

        Error error = new Error();

        error.setStatusCode("500");
        error.setStatusDescription("Failure");
//        error.setStatusMessage("Maximum retries exceeded");
        error.setStatusMessage(ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
