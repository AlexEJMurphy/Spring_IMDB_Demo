package com.imdbWebApp.rest_service;

import com.opencsv.exceptions.CsvException;
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

//TODO: Query actual names against name id,
// use parallel streams to improve performance
// integrate database display into search movies page
// search titles by tokens(?)
@SpringBootApplication
public class RestServiceApplication {
    private static final Logger log = LoggerFactory.getLogger(RestServiceApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(RestServiceApplication.class, args);
    }

    @Autowired
    TsvParserService tsvParserService;


    @PostConstruct
    public void importBasicsAndCrewDataToOneQueryObject(){
        try{
            tsvParserService.parseCrewAndMovieIntoQueryObjectAndSave("C:\\Users\\Alexander.Murphy\\Downloads\\title.basics.tsv\\title.basics.tsv", "C:\\Users\\Alexander.Murphy\\Downloads\\title.crew.tsv\\title.crew.tsv");
        } catch (IOException | CsvException e) {
            throw new RuntimeException(e);
        }
    }

    @Bean
    public CommandLineRunner displayImdb(IMDBRepository imdbRepository, IMDBCrewRepository imdbCrewRepository, IMDBMovieAndCrewRepository imdbMovieAndCrewRepository) {
        return (args) -> {
            imdbMovieAndCrewRepository.findAll().forEach(getCrewForMovieTitle -> {
                log.info(getCrewForMovieTitle.toString());
            });
        };

    }
}
