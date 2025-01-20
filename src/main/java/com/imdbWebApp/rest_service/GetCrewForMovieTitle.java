package com.imdbWebApp.rest_service;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;

import java.util.List;
@Entity
public class GetCrewForMovieTitle {
    @Id
    String basicsId;
    String title;
    String ordering;
    String crewId;
    @ElementCollection(fetch= FetchType.EAGER)
    List<String> directors;
    @ElementCollection(fetch = FetchType.EAGER)
    List<String> writers;

    public String getBasicsId() {
        return basicsId;
    }

    public void setBasicsId(String basicsId) {
        this.basicsId = basicsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getOrdering() {
        return ordering;
    }

    public void setOrdering(String ordering) {
        this.ordering = ordering;
    }

    public String getCrewId() {
        return crewId;
    }

    public void setCrewId(String crewId) {
        this.crewId = crewId;
    }

    @Override
    public String toString() {
        return "GetCrewForMovieTitle{" +
                "basicsId='" + basicsId + '\'' +
                ", title='" + title + '\'' +
                ", ordering='" + ordering + '\'' +
                ", crewId='" + crewId + '\'' +
                ", directors=" + directors +
                ", writers=" + writers +
                '}';
    }
}
