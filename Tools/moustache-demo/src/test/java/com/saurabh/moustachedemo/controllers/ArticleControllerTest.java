package com.saurabh.moustachedemo.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestClient;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

/**
 * Integration test for {@link ArticleController}.
 *
 * <p>Migration notes (Spring Boot 4.0):
 * <ul>
 *   <li>{@code TestRestTemplate} was removed from {@code spring-boot-test};
 *       replaced with {@link RestClient} + {@link LocalServerPort} (manual base URL).</li>
 *   <li>JUnit {@code assertEquals}/{@code assertTrue} swapped for AssertJ
 *       {@code assertThat} — fluent chains and null-safe body assertions.</li>
 *   <li>{@code SpringBootTest.WebEnvironment.RANDOM_PORT} pulled in via static import.</li>
 *   <li>Local var typed with {@code var}; test name uses assertive verb
 *       ({@code index_contains_article}) instead of the {@code given/when/then} prefix.</li>
 * </ul>
 */
@SpringBootTest(webEnvironment = RANDOM_PORT)
class ArticleControllerTest {

    @LocalServerPort
    private int port;

    @Test
    void index_contains_article() {

        var entity = RestClient.create()
            .get()
            .uri("http://localhost:" + port + "/articles")
            .retrieve()
            .toEntity(String.class);

        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(entity.getBody()).contains("Article Title 1");
    }

}
