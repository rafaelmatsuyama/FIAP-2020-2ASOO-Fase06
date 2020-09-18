package br.com.fiap.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("br.com.fiap.repository")
@EntityScan("br.com.fiap.entity")
@ComponentScan("br.com.fiap")
public class MvcExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MvcExampleApplication.class, args);
	}

}
