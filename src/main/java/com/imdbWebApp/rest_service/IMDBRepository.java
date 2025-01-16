package com.imdbWebApp.rest_service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMDBRepository extends CrudRepository<Movie,Long> {
    List<Movie> findByTitle(String title);
}
