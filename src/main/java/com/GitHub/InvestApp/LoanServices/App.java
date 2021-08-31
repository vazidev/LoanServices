package com.GitHub.InvestApp.LoanServices;

/**
 * Invest App: Loan Service API
 * @author Leonard Nganga
 **/

import com.GitHub.InvestApp.LoanServices.controller.LoanController;
import com.datastax.oss.driver.api.core.CqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cassandra.CassandraAutoConfiguration;
import org.springframework.boot.autoconfigure.data.cassandra.CassandraDataAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import reactor.core.publisher.Mono;
import reactor.netty.http.server.HttpServer;


import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.time.Duration;

@SpringBootApplication
@RestController
@EnableEurekaClient
public class App {

	@Autowired
	private LoanController controller;
	private static final Logger log = LoggerFactory.getLogger("GUI");


	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	/** REST endpoint for the WEB GUI
	 * endPoint: ("")
	 */
	@GetMapping("/hello")
	public Mono<String> hello(){
		log.info("Hello world testing loaded" );
		return Mono.just("Hello and Welcome to the Financial Loans Department");
	}

	/**
	 * A REST End point to the HTML GUI
	 *  endPoint: ""
	 **/
	@GetMapping("")
	public void addViewControllers(ViewControllerRegistry registry) {
		log.info("Loading GUI interface" );
		registry.addViewController("").setViewName("forward:/LoanServices.html");
	}
}
