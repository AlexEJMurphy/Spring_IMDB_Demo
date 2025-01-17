package com.imdbWebApp.rest_service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IMDBRepository extends CrudRepository<Movie,Long> {
    Optional<Movie> findByTitle(String title);
}
