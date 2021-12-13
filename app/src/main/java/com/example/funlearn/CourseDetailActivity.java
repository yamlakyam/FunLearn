package com.example.funlearn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.funlearn.Models.AllUdemyData;
import com.example.funlearn.Models.CourseReviews;
import com.example.funlearn.Retrofit.ApiInterface;
import com.example.funlearn.Retrofit.BasicAuthInterceptor;
import com.example.funlearn.Util.Constants;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CourseDetailActivity extends AppCompatActivity {

    ImageView courseImageView;
    TextView courseTitleDetail, instructorDetail, DescriptionDetail;

    String imageLink, instructor, courseDetail, courseTitle;
    int courseId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);
        courseImageView = findViewById(R.id.courseImageView);
        courseTitleDetail = findViewById(R.id.courseTitleDetail);
        instructorDetail = findViewById(R.id.instructorDetail);
        DescriptionDetail = findViewById(R.id.DescriptionDetail);

        if (getIntent() != null) {
            imageLink = getIntent().getStringExtra("imageLink");
            instructor = getIntent().getStringExtra("instructor");
            courseDetail = getIntent().getStringExtra("courseDetail");
            courseId = getIntent().getIntExtra("courseId", 0);
            courseTitle = getIntent().getStringExtra("courseTitle");
            setValues();
            getAllTheReviews();

        }
    }

    private void getAllTheReviews() {
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new BasicAuthInterceptor(Constants.username, Constants.password)).build();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constants.BASE_URL).client(client).addConverterFactory(GsonConverterFactory.create()).build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        Call<CourseReviews> call = apiInterface.getReviews(courseId);

        call.enqueue(new Callback<CourseReviews>() {
            @Override
            public void onResponse(Call<CourseReviews> call, Response<CourseReviews> response) {
                response.body().getReviewList();
            }

            @Override
            public void onFailure(Call<CourseReviews> call, Throwable t) {

            }
        });

    }

    public void setValues() {
        Glide.with(getApplicationContext()).load(imageLink).into(courseImageView);
        courseTitleDetail.setText(courseTitle);
        instructorDetail.setText(instructor);
        DescriptionDetail.setText(courseDetail);

    }
}