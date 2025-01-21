package com.imdbWebApp.rest_service;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IMDBMovieAndCrewRepository extends CrudRepository<GetCrewForMovieTitle, String> {
    //Optional<GetCrewForMovieTitle> findByTitle(String title);
    Optional<GetCrewForMovieTitle> findWritersByTitle(String title);
}
