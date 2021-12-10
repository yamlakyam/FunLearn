package com.example.funlearn.Models;

import com.google.gson.annotations.SerializedName;

public class InstructorDetail {

    @SerializedName("title")
    private String title;

    @SerializedName("name")
    private String name;

    @SerializedName("job_title")
    private String job_title;

    @SerializedName("image_50x50")
    private String imageUrl;

    @SerializedName("url")
    private String url;

    public String getTitle() {
        return title;
    }

    public String getName() {
        return name;
    }

    public String getJob_title() {
        return job_title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
