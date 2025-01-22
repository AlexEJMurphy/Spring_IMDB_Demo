package com.imdbWebApp.rest_service;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Names {
    @Id
    String id;
    String primaryName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrimaryName() {
        return primaryName;
    }

    public void setPrimaryName(String primaryName) {
        this.primaryName = primaryName;
    }

    @Override
    public String toString() {
        return "Names{" +
                "id='" + id + '\'' +
                ", primaryName='" + primaryName + '\'' +
                '}';
    }
}
