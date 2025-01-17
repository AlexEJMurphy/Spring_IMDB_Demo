package com.imdbWebApp.rest_service;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;

@Service
public class TsvParserService {
    @Autowired
    IMDBRepository imdbRepository;
    @Autowired
    IMDBCrewRepository imdbCrewRepository;

    public void parseBasicsTsvFileAndSave(String filePath) throws IOException, CsvValidationException {
        try (CSVReader reader = new CSVReaderBuilder(new FileReader(filePath))
                .withCSVParser(new CSVParserBuilder().withSeparator('\t').build())
                .build()) {
            String[] line;
            int count = 0;
            while ((line = reader.readNext()) != null && count < 20) {
                Movie movie = new Movie();
                movie.setId(line[0]);
                movie.setOrdering(line[1]);
                movie.setTitle(line[2]);
                imdbRepository.save(movie);
                count++;
            }
        }
    }

    public void parseCrewTsvFileAndSave(String filePath) throws IOException, CsvValidationException {
        try (CSVReader reader = new CSVReaderBuilder(new FileReader(filePath))
                .withCSVParser(new CSVParserBuilder().withSeparator('\t').build())
                .build()) {
            String[] line;
            String[] array;
            int count = 0;
            while ((line = reader.readNext()) != null && count < 20) {
                Crew crew = new Crew();
                crew.setId(line[0]);
                String[] directors = line[1].split(",");
                //for(int i=0; i< directors.length; i++) directors[i]=directors[i].trim();
                crew.setDirectors(directors);
                String[] writers = line[2].split(",");
                //for(int i=0; i< writers.length; i++) writers[i]=writers[i].trim();
                crew.setWriters(writers);
                imdbCrewRepository.save(crew);
                count++;
            }
        }
    }
}
