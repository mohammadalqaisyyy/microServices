package com.services.mySqlDB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.services.mySqlDB")
public class MySqlDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySqlDbApplication.class, args);
	}

}
