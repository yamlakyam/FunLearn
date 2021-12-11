package com.example.funlearn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

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
        }
    }

    public void setValues() {
        Glide.with(getApplicationContext()).load(imageLink).into(courseImageView);
        courseTitleDetail.setText(courseTitle);
        instructorDetail.setText(instructor);
        DescriptionDetail.setText(courseDetail);

    }
}