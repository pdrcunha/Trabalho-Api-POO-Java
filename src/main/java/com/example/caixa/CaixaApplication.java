package com.example.caixa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class CaixaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaixaApplication.class, args);
	}
}
