package com.imdbWebApp.rest_service;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class TsvParserService {

    @Autowired
    IMDBMovieAndCrewRepository imdbMovieAndCrewRepository;

    //Not exactly a method uncle bob would approve of
    public void parseCrewAndMovieIntoQueryObjectAndSave(String dataset1FilePath, String dataset2FilePath) throws IOException, CsvException {
        Map<String, GetCrewForMovieTitle> mapOfMoviesAndCrews = new HashMap<>();
        List<GetCrewForMovieTitle> batchToSave = new ArrayList<>();
        int batchSize = 1000;
        // 1 reader for each dataset passed into the method
        try (BufferedReader br1 = new BufferedReader(new FileReader(dataset1FilePath));
             BufferedReader br2 = new BufferedReader(new FileReader(dataset2FilePath));
             CSVReader reader1 = new CSVReaderBuilder(br1)
                     .withCSVParser(new CSVParserBuilder()
                             .withSeparator('\t')
                             .build()).build();
             CSVReader reader2 = new CSVReaderBuilder(br2).
                     withCSVParser(new CSVParserBuilder()
                             .withSeparator('\t')

                             .build()).build()) {
            //array for each dataset
            String[] line1;
            String[] line2;
            int count = 0;

            while ((line1 = reader1.readNext()) != null &&
                    (line2 = reader2.readNext()) != null &&
                    count < 1000) {

                //process dataset 1 (basics)
                GetCrewForMovieTitle getCrewForMovieTitle = new GetCrewForMovieTitle();
                getCrewForMovieTitle.setBasicsId(line1[0]);
                getCrewForMovieTitle.setOrdering(line1[1]);
                getCrewForMovieTitle.setTitle(line1[2]);

                //process dataset 2 (crew)
                getCrewForMovieTitle.setCrewId(line2[0]);

                //split if multiple directors/writers
                List<String> directors = Arrays.asList(line2[1].split(",")).stream()
                        .map(String::trim)
                        .collect(Collectors.toList());
                getCrewForMovieTitle.setDirectors(directors);

                List<String> writers = Arrays.asList(line2[2].split(",")).stream()
                        .map(String::trim)
                        .collect(Collectors.toList());
                getCrewForMovieTitle.setWriters(writers);

                mapOfMoviesAndCrews.put(line1[0], getCrewForMovieTitle);

                    batchToSave.add(getCrewForMovieTitle);
                    if (batchToSave.size() >= batchSize) {
                        imdbMovieAndCrewRepository.saveAll(batchToSave);
                        batchToSave.clear();
                    }

                count++;
            }
        }
    }
}

