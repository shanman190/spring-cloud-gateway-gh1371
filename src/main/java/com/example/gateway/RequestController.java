package com.example.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
public class RequestController {
    private static final Logger logger = LoggerFactory.getLogger(RequestController.class);

    @GetMapping("/get")
    public Mono<String> getRequest() {
        logger.info("Calling get method");
        return Mono.just("get")
                .delayElement(Duration.ofSeconds(10));
    }

    @PostMapping("/post")
    public Mono<String> postRequest() {
        logger.info("Calling post method");
        return Mono.just("post")
                .delayElement(Duration.ofSeconds(10));
    }

    @PutMapping("/put")
    public Mono<String> putRequest() {
        logger.info("Calling put method");
        return Mono.just("put")
                .delayElement(Duration.ofSeconds(10));
    }

    @PatchMapping("/patch")
    public Mono<String> patchRequest() {
        logger.info("Calling patch method");
        return Mono.just("patch")
                .delayElement(Duration.ofSeconds(10));
    }

    @DeleteMapping("/delete")
    public Mono<String> deleteRequest() {
        logger.info("Calling delete method");
        return Mono.just("delete")
                .delayElement(Duration.ofSeconds(10));
    }
}
