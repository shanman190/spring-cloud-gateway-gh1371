package com.example.gateway;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.Duration;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = DEFINED_PORT)
public class GatewayRetryDemoApplicationTests {

    @LocalServerPort
    private int port = 0;

    private WebTestClient webClient;

    @Before
    public void setup() {
        webClient = WebTestClient.bindToServer(new ReactorClientHttpConnector()).baseUrl("http://localhost:" + port)
                .responseTimeout(Duration.ofSeconds(30))
                .build();
    }

    @Test
    public void contextLoads() {
    }

    @Test
    public void testGetRetry() {
        webClient.get()
                .uri("/httpbin/get")
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    public void testPostRetry() {
        webClient.post()
                .uri("/httpbin/post")
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    public void testPutRetry() {
        webClient.put()
                .uri("/httpbin/put")
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    public void testPatchRetry() {
        webClient.patch()
                .uri("/httpbin/patch")
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    public void testDeleteRetry() {
        webClient.delete()
                .uri("/httpbin/delete")
                .exchange()
                .expectStatus().isOk();
    }
}
