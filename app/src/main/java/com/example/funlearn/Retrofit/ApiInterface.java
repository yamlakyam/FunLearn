package com.example.funlearn.Retrofit;

import com.example.funlearn.Models.CourseInfo;

import java.util.List;

import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface ApiInterface {

    @Headers({
            "Accept: application/json, text/plain, */*",

            "Content-Type: application/json;charset=utf-8"
            })
    @GET("https://www.udemy.com/api-2.0/courses/")
    public void getAllUdemyData(Callback<List<CourseInfo>> callback);
}


