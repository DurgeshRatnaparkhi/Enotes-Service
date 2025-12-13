package com.becoder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAware")
public class EnotesApiServiceApplication {

	public static void main(String[] args) {
		
		System.out.println("run project....");
		SpringApplication.run(EnotesApiServiceApplication.class, args);
	}

}
