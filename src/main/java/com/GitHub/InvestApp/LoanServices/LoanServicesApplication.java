package com.GitHub.InvestApp.LoanServices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cassandra.CassandraAutoConfiguration;
import org.springframework.boot.autoconfigure.data.cassandra.CassandraDataAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@SpringBootApplication (exclude = {CassandraDataAutoConfiguration.class, CassandraAutoConfiguration.class})
@RestController
@EnableEurekaClient
public class LoanServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanServicesApplication.class, args);
	}
	@GetMapping("")
	public Mono<String> hello(){
		return Mono.just("Hello and Welcome to the Financial Loan Department");
	}
}
