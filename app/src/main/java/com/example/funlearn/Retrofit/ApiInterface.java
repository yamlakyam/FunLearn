package com.example.funlearn.Retrofit;

import com.example.funlearn.Models.AllUdemyData;
import com.example.funlearn.Models.CourseInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface ApiInterface {

    //    @GET("https://www.udemy.com/api-2.0/courses/")

    @GET("courses")
    Call<AllUdemyData> getCourses();
//    Call<List<CourseInfo>> getCourses();

//    public void getAllUdemyData(Callback<List<CourseInfo>> callback);
}


