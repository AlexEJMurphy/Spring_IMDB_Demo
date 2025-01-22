package com.imdbWebApp.rest_service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IMDBMovieAndCrewRepository extends CrudRepository<GetCrewForMovieTitle, String> {
    //Optional<GetCrewForMovieTitle> findByTitle(String title);
    Optional<GetCrewForMovieTitle> findWritersByTitle(String title);
}
