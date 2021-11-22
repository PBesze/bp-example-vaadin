package org.vaadin.bpexampleapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.vaadin.bpexampleapp.model.Product;
import org.vaadin.bpexampleapp.model.ProductRepository;

@SpringBootApplication

@ComponentScan({"org.vaadin.bpexampleapp"})
@EntityScan("org.vaadin.bpexampleapp")
@EnableJpaRepositories("org.vaadin.bpexampleapp")
public class BpExampleAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BpExampleAppApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner loadData(ProductRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.save( new Product("Gold", 10.00));
			repository.save( new Product("Silver", 50.00));
			};
	}
}
