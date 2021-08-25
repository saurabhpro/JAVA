package com.jetbrains.testcontainersdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Testcontainers
public class CustomerIntegrationTests {

    private final CustomerDao customerDao;

    @Container
    private static final MySQLContainer mySQLContainer = (MySQLContainer) new MySQLContainer("mysql:8.0")
            .withUsername("root")
            .withPassword("password")
            .withReuse(true);

    @DynamicPropertySource
    public static void setDatasourceProperties(final DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", mySQLContainer::getJdbcUrl);
        // registry.add("spring.datasource.password", mySQLContainer::getPassword);
        // registry.add("spring.datasource.username", mySQLContainer::getUsername);
    }

    @Autowired
    CustomerIntegrationTests(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Test
    void when_using_a_clean_db_this_should_be_empty() {
        List<Customer> customers = customerDao.findAll();
        assertThat(customers).hasSize(2);
    }
}
