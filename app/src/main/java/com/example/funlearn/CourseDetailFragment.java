package com.example.funlearn;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class CourseDetailFragment extends Fragment {

    String imageLink, instructor, courseDetail, courseTitle;
    int courseId;

    ImageView courseImageView;
    TextView courseTitleDetail;
    TextView instructorDetail;
    TextView descriptionDetail;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_course_detail, container, false);

        courseImageView = view.findViewById(R.id.courseImageView);
        courseTitleDetail = view.findViewById(R.id.courseTitleDetail);
        instructorDetail = view.findViewById(R.id.instructorDetail);
        descriptionDetail = view.findViewById(R.id.DescriptionDetail);

        if (getArguments() != null) {
            imageLink = getArguments().getString("imageLink");
            instructor = getArguments().getString("instructor");
            courseDetail = getArguments().getString("courseDetail");
            courseId = getArguments().getInt("courseId");
            courseTitle = getArguments().getString("courseTitle");

            setValues();
        }

        return view;
    }

    public void setValues() {
        Glide.with(getContext()).load(imageLink).into(courseImageView);
        courseTitleDetail.setText(courseTitle);
        instructorDetail.setText(instructor);
        descriptionDetail.setText(courseDetail);

    }
}