package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@SpringBootApplication
@EnableScheduling
@RestController
@CrossOrigin
public class DemoApplication {
	public static String RANDOM_NUMBER;
	@Scheduled(fixedRate = 30000)
	public static String cronJobSch() throws Exception {
		Random rnd = new Random();
		int number = rnd.nextInt(999999);
		RANDOM_NUMBER = String.format("%06d", number);
		return RANDOM_NUMBER;
	}

	@GetMapping("/test")
	public String getRandomNumber() throws Exception {
		return RANDOM_NUMBER;
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(DemoApplication.class, args);
	}

}
