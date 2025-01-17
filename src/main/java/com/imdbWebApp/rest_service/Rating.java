package com.imdbWebApp.rest_service;

public class Rating {
    String id;
    double averageRating;
    long numberOfVotes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public long getNumberOfVotes() {
        return numberOfVotes;
    }

    public void setNumberOfVotes(long numberOfVotes) {
        this.numberOfVotes = numberOfVotes;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "averageRating=" + averageRating +
                ", numberOfVotes=" + numberOfVotes +
                '}';
    }
}
