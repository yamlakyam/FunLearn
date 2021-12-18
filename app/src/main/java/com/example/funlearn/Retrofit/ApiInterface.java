package com.example.funlearn.Retrofit;

import com.example.funlearn.Models.AllUdemyData;
import com.example.funlearn.Models.CourseInfo;
import com.example.funlearn.Models.CourseReviews;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface ApiInterface {

    //    @GET("https://www.udemy.com/api-2.0/courses/")

    @GET("/api-2.0/courses/?page_size=100")
    Call<AllUdemyData> getCourses();

    @GET("/api-2.0/courses/{id}/reviews")
    Call<CourseReviews> getReviews(@Path("id") int id);

    @GET("/api-2.0/courses/{id}")
    Call<CourseInfo> getCourseDetail(@Path("id") int id);

    @GET("/api-2.0/courses/")
    Call<AllUdemyData> getFilteredCourses(@QueryMap Map<String, String> params);


//    public void getAllUdemyData(Callback<List<CourseInfo>> callback);
}


