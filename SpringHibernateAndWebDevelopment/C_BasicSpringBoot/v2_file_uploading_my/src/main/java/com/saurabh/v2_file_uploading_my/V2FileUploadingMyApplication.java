package com.saurabh.v2_file_uploading_my;

import com.saurabh.v2_file_uploading_my.storage.service.IStorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@SpringBootApplication
public class V2FileUploadingMyApplication {

	public static void main(String[] args) {
		SpringApplication.run(V2FileUploadingMyApplication.class, args);
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer getPropertySourcesPlaceholderConfigurer() {
		//placeholderConfigurer.setLocation(new ClassPathResource("second.properties"));

		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	CommandLineRunner init(IStorageService IStorageService) {
		return (args) -> {
			IStorageService.deleteAll();
			IStorageService.init();
		};
	}
}
