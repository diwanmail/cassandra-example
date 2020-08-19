package com.datastax.astrakathon.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cassandra.CassandraAutoConfiguration;

@SpringBootApplication(scanBasePackages = {"com.datastax.astrakathon.apartmentrentalsystem", "com.datastax.astrakathon.config", "com.datastax.astrakathon.controller", 
		"com.datastax.astrakathon.doc", "com.datastax.astrakathon.service"})
@EnableAutoConfiguration(exclude = {CassandraAutoConfiguration.class})
public class ApartmentRentalSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApartmentRentalSystemApplication.class, args);
	}

}
