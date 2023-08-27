package com.goldilock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class LoginAndSuccessApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginAndSuccessApplication.class, args);
	}

}
