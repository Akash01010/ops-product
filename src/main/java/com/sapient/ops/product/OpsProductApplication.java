package com.sapient.ops.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages="com.sapient.ops")
@EnableJpaRepositories(basePackages="com.sapient.ops.dao")
@EntityScan("com.sapient.ops.model")
public class OpsProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpsProductApplication.class, args);
	}
}
