package com.emirates.couchbase.emiratesmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;


/**
 * @author yogesh.jadhav
 * Base and Configuration class for spring boot application kickoff.
 */
@Configuration
@ComponentScan(basePackages={"com.emirates.couchbase"})
@EnableCouchbaseRepositories(basePackages = {"com.emirates.couchbase"})
@SpringBootApplication
public class EmiratesMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmiratesMicroserviceApplication.class, args);
	}

}

