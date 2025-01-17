package com.imdbWebApp.rest_service;

import com.opencsv.exceptions.CsvValidationException;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;


@SpringBootApplication
public class RestServiceApplication {
    private static final Logger log = LoggerFactory.getLogger(RestServiceApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(RestServiceApplication.class, args);
    }

//    public RestServiceApplication(CustomerRepository repository) {
//    }

    @Autowired
    TsvParserService tsvParserService;

    @PostConstruct
    public void importBasicsData() {
        try {
            tsvParserService.parseBasicsTsvFileAndSave("C:\\Users\\Alexander.Murphy\\Downloads\\title.basics.tsv\\title.basics.tsv");
        } catch (IOException | CsvValidationException e) {
            // Handle exception
        }
    }

    @PostConstruct
    public void importRatingsData() {
        try {
            tsvParserService.parseCrewTsvFileAndSave("C:\\Users\\Alexander.Murphy\\Downloads\\title.crew.tsv\\title.crew.tsv");
        } catch (IOException | CsvValidationException e) {
            // Handle exception
        }
    }

    @Bean
    public CommandLineRunner displayImdb(IMDBRepository imdbRepository, IMDBCrewRepository imdbCrewRepository) {
        return (args) -> {
            imdbRepository.findAll().forEach(movie -> {
                log.info(movie.toString());
            });
            imdbCrewRepository.findAll().forEach(crew -> {
                log.info(crew.toString());
            });
        };


//	@Bean
//	public CommandLineRunner demo(CustomerRepository repository) {
//		return (args) -> {
//			// save a few customers
//			repository.save(new Customer("Jack", "Bauer", 45));
//			repository.save(new Customer("Chloe", "O'Brian", 52));
//			repository.save(new Customer("Kim", "Bauer", 32));
//			repository.save(new Customer("David", "Palmer", 21));
//			repository.save(new Customer("Michelle", "Kessler", 19));
//
//			// fetch all customers
//			log.info("Customers found with findAll():");
//			log.info("-------------------------------");
//			repository.findAll().forEach(customer -> {
//				log.info(customer.toString());
//			});
//			log.info("");
//
//			// fetch an individual customer by ID
//			Customer customer = repository.findById(1L);
//			log.info("Customer found with findById(1L):");
//			log.info("--------------------------------");
//			log.info(customer.toString());
//			log.info("");
//
//			// fetch customers by last name
//			log.info("Customer found with findByLastName('Bauer'):");
//			log.info("--------------------------------------------");
//			repository.findByLastName("Bauer").forEach(bauer -> {
//				log.info(bauer.toString());
//			});
//			log.info("");
//		};
//	}

    }
}
