package com.imdbWebApp.rest_service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IMDBCrewRepository extends CrudRepository<Crew, String> {
    Optional<Crew> findByDirectors(List<String>directors);
    Optional<Crew> findByWriters(List<String> writers);
}
