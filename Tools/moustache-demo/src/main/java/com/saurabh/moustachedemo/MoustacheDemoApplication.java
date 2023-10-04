package com.saurabh.moustachedemo;

import com.samskivert.mustache.Mustache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mustache.MustacheEnvironmentCollector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

@SpringBootApplication
@ComponentScan(basePackages = {"com.saurabh"})
public class MoustacheDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoustacheDemoApplication.class, args);
    }

}
