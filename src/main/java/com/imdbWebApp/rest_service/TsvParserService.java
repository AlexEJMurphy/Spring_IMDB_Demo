package com.imdbWebApp.rest_service;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.util.List;
import java.io.File;
import java.io.IOException;

@Service
public class TsvParserService {
    @Autowired

    IMDBRepository imdbRepository;

    public void parseTsvFileAndSave(String filePath) throws IOException, CsvValidationException {
        try (CSVReader reader = new CSVReaderBuilder(new FileReader(filePath))
                .withCSVParser(new CSVParserBuilder().withSeparator('\t').build())
                .build()) {
            String[] line;
            int count = 0;
            while ((line = reader.readNext()) !=null && count < 20){

                Movie movie = new Movie();
                movie.setId(line[0]);
                movie.setOrdering(line[1]);
                movie.setTitle(line[2]);
                imdbRepository.save(movie);
                count++;

            }
        }

    }
}
