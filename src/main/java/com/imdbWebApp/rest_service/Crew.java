package com.imdbWebApp.rest_service;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@Entity
public class Crew implements Serializable{
    //TODO: Use DTO's instead of FetchType.EAGER

    @Id
    String id;
    @ElementCollection(fetch=FetchType.EAGER)
    List<String> directors;
    @ElementCollection(fetch=FetchType.EAGER)
    List<String> writers;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getDirectors() {
        return directors;
    }

    public void setDirectors(List<String> directors) {
        this.directors = directors;
    }

    public List<String> getWriters() {
        return writers;
    }

    public void setWriters(List<String> writers) {
        this.writers = writers;
    }

    @Override
    public String toString() {
        return "Crew{" +
                "id='" + id + '\'' +
                ", directors='" + directors + '\'' +
                ", writers='" + writers + '\'' +
                '}';
    }
}
