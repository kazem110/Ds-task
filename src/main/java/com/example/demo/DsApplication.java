package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;

 @SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
 @EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})


public class DsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DsApplication.class, args);
	}

}
