package com.jetbrains.testcontainersdemo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.containers.output.Slf4jLogConsumer;
import org.testcontainers.utility.MountableFile;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
//@Testcontainers
public class CustomerIntegrationTests {

    public static final Logger LOGGER = LoggerFactory.getLogger(CustomerIntegrationTests.class);
    private final CustomerDao customerDao;

    // docker run -e MYSQL_USERNAME=... MYSQL_PASSWORD=... mysql:8.0.26
//    @Container
    private static final MySQLContainer<?> mySQLContainer = new MySQLContainer<>("mysql:8.0.26")
           // .withExposedPorts(3306)    // keep trying to get this port and only then run the tests
//            .withUsername("root")
//            .withPassword("password")
            .withReuse(true);   // if the container is started just reuse


//    @Container
//    private static final RabbitMQContainer rabbitMQContainer = new RabbitMQContainer("rabbitmq:latest");

//    @Container
//    private static final GenericContainer<?> genericContainer = new GenericContainer<>("rabbitmq:latest");


    @DynamicPropertySource
    public static void setDatasourceProperties(final DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", mySQLContainer::getJdbcUrl);

        // take these values dynamically also
        registry.add("spring.datasource.password", mySQLContainer::getPassword);
        registry.add("spring.datasource.username", mySQLContainer::getUsername);
    }

    @Autowired
    CustomerIntegrationTests(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }


    @BeforeAll
    public static void setup() {
        mySQLContainer.start(); // only then we can use reuse
    }

    @Test
    void when_using_a_clean_db_this_should_be_empty() throws IOException, InterruptedException {

        // additional methods you want to use
        mySQLContainer.copyFileToContainer(MountableFile.forClasspathResource("application.properties"),
                "/tmp/app.properties");

        final org.testcontainers.containers.Container.ExecResult ls = mySQLContainer.execInContainer("ls", "-la");
        LOGGER.info(ls.getStdout());

        mySQLContainer.withLogConsumer(new Slf4jLogConsumer(LOGGER));

        final Integer mappedPort = mySQLContainer.getMappedPort(3306);
        LOGGER.info("My current assigned post = {}", mappedPort);

        List<Customer> customers = customerDao.findAll();
        assertThat(customers).hasSize(2);
    }
}
