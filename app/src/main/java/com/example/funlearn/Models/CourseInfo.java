package com.example.funlearn.Models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CourseInfo {

    @SerializedName("id")
    private int courseId;

    @SerializedName("title")
    private String title;

    @SerializedName("url")
    private String url;

    @SerializedName("is_paid")
    private boolean isPaid;

    @SerializedName("price")
    private String price;

    @SerializedName("price_detail")
    private PriceDetail priceDetail;

    @SerializedName("image_480x270")
    private String imageLink;

    @SerializedName("published_title")
    private String publishedTitle;

    @SerializedName("headline")
    private String headline;

    @SerializedName("visible_instructors")
    private ArrayList<InstructorDetail> instructorDetailArrayList;

    public int getCourseId() {
        return courseId;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public String getPrice() {
        return price;
    }

    public PriceDetail getPriceDetail() {
        return priceDetail;
    }

    public String getImageLink() {
        return imageLink;
    }

    public String getPublishedTitle() {
        return publishedTitle;
    }

    public String getHeadline() {
        return headline;
    }

    public ArrayList<InstructorDetail> getInstructorDetailArrayList() {
        return instructorDetailArrayList;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setPriceDetail(PriceDetail priceDetail) {
        this.priceDetail = priceDetail;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public void setPublishedTitle(String publishedTitle) {
        this.publishedTitle = publishedTitle;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public void setInstructorDetailArrayList(ArrayList<InstructorDetail> instructorDetailArrayList) {
        this.instructorDetailArrayList = instructorDetailArrayList;
    }
}
