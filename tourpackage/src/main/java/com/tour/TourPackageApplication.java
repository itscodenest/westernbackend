package com.tour;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.tour")

@EntityScan(basePackages = "com.tourcoreservice.entity")

public class TourPackageApplication {

	public static void main(String[] args) {
		SpringApplication.run(TourPackageApplication.class, args);
	}

}
