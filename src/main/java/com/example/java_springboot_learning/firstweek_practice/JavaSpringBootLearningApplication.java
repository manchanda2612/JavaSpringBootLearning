package com.example.java_springboot_learning.firstweek_practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaSpringBootLearningApplication implements CommandLineRunner {

	@Autowired
	Apple apple1;
//
	@Autowired
	Apple apple2;

//	@Autowired
//	DBService dbService;

	public static void main(String[] args) {
		SpringApplication.run(JavaSpringBootLearningApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

	//	System.out.println(dbService.getData());

		apple2.eatApple();
		apple1.eatApple();
//
	System.out.println(apple1.hashCode());
		System.out.println(apple2.hashCode());
	}
}
