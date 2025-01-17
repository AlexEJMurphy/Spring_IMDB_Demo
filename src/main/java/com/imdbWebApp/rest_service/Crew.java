package com.imdbWebApp.rest_service;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Arrays;
import java.util.List;

@Entity
public class Crew {
    @Id
    String id;
    @ElementCollection
    List<String> directors;
    @ElementCollection
    List<String> writers;

    String writersString = Arrays.toString(writers);


    String writersToString;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getDirectors() {
        return directors;
    }

    public void setDirectors(String[] director) {
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
                "directors='" + directors + '\'' +
                ", writers='" + writersString + '\'' +
                '}';
    }
}
