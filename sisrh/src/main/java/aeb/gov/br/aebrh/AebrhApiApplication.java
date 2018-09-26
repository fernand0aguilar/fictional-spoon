package aeb.gov.br.aebrh;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ComponentScan(basePackages = "aeb.gov.br")
@EnableAutoConfiguration
@ImportResource("classpath:spring-ldap.xml")
public class AebrhApiApplication {
	private static final Logger log = LoggerFactory.getLogger(AebrhApiApplication.class);

	public static void main(String[] args) {
		log.info("Incializando configurações");
		log.info("teste");

		SpringApplication.run(AebrhApiApplication.class, args);
	}
}
