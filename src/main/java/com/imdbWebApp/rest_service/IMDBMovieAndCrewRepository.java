package com.imdbWebApp.rest_service;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IMDBMovieAndCrewRepository extends CrudRepository<GetCrewForMovieTitle, String> {
    Optional<Movie> findByTitle(String title);
    Optional<Movie> findWritersByTitle(String title);
}
