package com.example.funlearn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.funlearn.Models.AllUdemyData;
import com.example.funlearn.Models.CourseInfo;
import com.example.funlearn.Models.CourseReviews;
import com.example.funlearn.Models.InstructorDetail;
import com.example.funlearn.Retrofit.ApiInterface;
import com.example.funlearn.Retrofit.BasicAuthInterceptor;
import com.example.funlearn.Util.Constants;

import java.util.ArrayList;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CourseDetailActivity extends AppCompatActivity {

    ImageView courseImageView;
    TextView courseTitleDetail, instructorDetail, DescriptionDetail, starDetail, coursePriceTxt;
    LinearLayout instructorListLayout;

    String imageLink, instructor, courseDetail, courseTitle;
    int courseId;

    double x = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);
        courseImageView = findViewById(R.id.courseImageView);
        courseTitleDetail = findViewById(R.id.courseTitleDetail);
        instructorDetail = findViewById(R.id.instructorDetail);
        DescriptionDetail = findViewById(R.id.DescriptionDetail);
        starDetail = findViewById(R.id.starDetail);
        instructorListLayout = findViewById(R.id.instructorListLayout);
        coursePriceTxt = findViewById(R.id.coursePriceTxt);

        if (getIntent() != null) {
            imageLink = getIntent().getStringExtra("imageLink");
            instructor = getIntent().getStringExtra("instructor");
            courseDetail = getIntent().getStringExtra("courseDetail");
            courseId = getIntent().getIntExtra("courseId", 0);
            courseTitle = getIntent().getStringExtra("courseTitle");
            setValues();
            getAllTheReviews();
            getCourseDetail();

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
                Log.i("TAG", response.body().getReviewList() + "");
//            response.body().getReviewList();


                for (int i = 0; i < response.body().getReviewList().size(); i++) {

                    x = x + response.body().getReviewList().get(i).getRating();
                }
                x = x / response.body().getReviewList().size();

                Log.i("avg", x + "");
                starDetail.setText(String.valueOf(x));

            }

            @Override
            public void onFailure(Call<CourseReviews> call, Throwable t) {

            }
        });

    }

    private void getCourseDetail() {
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new BasicAuthInterceptor(Constants.username, Constants.password)).build();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constants.BASE_URL).client(client).addConverterFactory(GsonConverterFactory.create()).build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<CourseInfo> call = apiInterface.getCourseDetail(courseId);
        call.enqueue(new Callback<CourseInfo>() {
            @Override
            public void onResponse(Call<CourseInfo> call, Response<CourseInfo> response) {
                CourseInfo courseInfoResponse = response.body();

                coursePriceTxt.setText(String.valueOf(courseInfoResponse.getPrice()));
                ArrayList<InstructorDetail> instructorDetailArrayList = courseInfoResponse.getInstructorDetailArrayList();

                for (int i = 0; i < instructorDetailArrayList.size(); i++) {

                    InstructorDetail instructorDetailAtI = instructorDetailArrayList.get(i);

                    LayoutInflater instructorCardInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    View instructorLayout = instructorCardInflater.inflate(R.layout.instructor_layout, null, false);
                    ImageView instructorImage = instructorLayout.findViewById(R.id.instructorImage);
                    TextView instructorName = instructorLayout.findViewById(R.id.instructorName);
                    TextView instructorJob = instructorLayout.findViewById(R.id.instructorJob);

                    Glide.with(getApplicationContext()).load(instructorDetailAtI.getImageUrl()).into(instructorImage);
                    instructorName.setText(instructorDetailAtI.getName());
                    instructorJob.setText(instructorDetailAtI.getJob_title());

                    View view = new View(getApplicationContext());
                    view.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 10));

                    instructorListLayout.addView(instructorLayout);
                    instructorListLayout.addView(view);

                }
            }

            @Override
            public void onFailure(Call<CourseInfo> call, Throwable t) {

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