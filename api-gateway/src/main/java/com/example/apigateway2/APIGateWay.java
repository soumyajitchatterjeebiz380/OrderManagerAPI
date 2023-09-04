package com.example.apigateway2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class APIGateWay {
	public static void main(String[] args) {
		SpringApplication.run(APIGateWay.class, args);
	}

}
