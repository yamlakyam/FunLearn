package com.example.funlearn.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CourseReviews {
    @SerializedName("count")
    private int count;

    @SerializedName("results")
    private List<Review> reviewList;

    public int getCount() {
        return count;
    }

    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }
}
