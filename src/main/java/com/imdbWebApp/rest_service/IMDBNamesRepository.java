package com.imdbWebApp.rest_service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMDBNamesRepository extends CrudRepository<Names, String> {

}
