package com.despegar.hoteles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class OrquestacionHotelesApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrquestacionHotelesApplication.class, args);
	}

}
