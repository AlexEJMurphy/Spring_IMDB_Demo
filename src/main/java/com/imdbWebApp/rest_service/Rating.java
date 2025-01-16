package com.imdbWebApp.rest_service;

public class Rating {
    double averageRating;
    long numberOfVotes;

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
