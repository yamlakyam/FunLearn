package com.example.funlearn.Models;

import com.google.gson.annotations.SerializedName;

public class Review {

    @SerializedName("id")
    private int id;

    @SerializedName("content")
    private String comment;

    @SerializedName("rating")
    private double rating;

    @SerializedName("user")
    private Reviewer user;

    public int getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }

    public double getRating() {
        return rating;
    }

    public Reviewer getUser() {
        return user;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setUser(Reviewer user) {
        this.user = user;
    }
}
