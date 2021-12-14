package com.example.funlearn.Retrofit;

import com.example.funlearn.Models.AllUdemyData;
import com.example.funlearn.Models.CourseInfo;
import com.example.funlearn.Models.CourseReviews;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface ApiInterface {

    //    @GET("https://www.udemy.com/api-2.0/courses/")

    @GET("courses")
    Call<AllUdemyData> getCourses();

    @GET("courses/{id}/reviews")
    Call<CourseReviews> getReviews(@Path("id") int id);

//    public void getAllUdemyData(Callback<List<CourseInfo>> callback);
}


