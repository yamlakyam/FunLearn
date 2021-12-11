package com.example.funlearn;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.funlearn.Models.AllUdemyData;
import com.example.funlearn.Models.CourseInfo;
import com.example.funlearn.Retrofit.ApiInterface;
import com.example.funlearn.Retrofit.BasicAuthInterceptor;

import java.util.ArrayList;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ExploreFragment extends Fragment {
    HorizontalScrollView horizontalScrollView;
    LinearLayout horizontalScrollLL;

    private static final String BASE_URL = "https://www.udemy.com/api-2.0/";

    public static ArrayList<CourseInfo> courseInfoArrayList;

    Fragment fragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_explore, container, false);

        fragment = this;

        horizontalScrollView = view.findViewById(R.id.horizontalScrollViewExplore);
        horizontalScrollLL = view.findViewById(R.id.horizontalScrollLL);

        String username = "KWr09PPO6cuarAQ23r22fUCTMTJluKIpkheoN3eE";
        String password = "55iS1BiEsxIfx3osg9MXlHhKW1AOhzWaXcNbAjzJDssqFtYQpYxAwZ4xvHqXZ94PgbdDVEjIsMXjL7NHh0y0pWdweTvTzE9UhkSA04nS4UCdsmiuSqDruR0ATUaKVI9J";

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new BasicAuthInterceptor(username, password)).build();

//            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).client(client).addConverterFactory(GsonConverterFactory.create()).build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        Call<AllUdemyData> call = apiInterface.getCourses();

        call.enqueue(new Callback<AllUdemyData>() {
            @Override
            public void onResponse(Call<AllUdemyData> call, Response<AllUdemyData> response) {
                Log.i("onResponse", response.body().getCourseInfoArrayList().toString());

                courseInfoArrayList = new ArrayList<>();
                courseInfoArrayList.addAll(response.body().getCourseInfoArrayList());

                Log.i("All courses", courseInfoArrayList.get(0).getHeadline() + "");

                drawCourseCards();
            }

            @Override
            public void onFailure(Call<AllUdemyData> call, Throwable t) {

            }
        });


        return view;
    }

    private void drawCourseCards() {
        for (int i = 0; i < courseInfoArrayList.size(); i++) {
            CourseInfo courseInfo = courseInfoArrayList.get(i);

            LayoutInflater courseCardInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View cardElementView = courseCardInflater.inflate(R.layout.course_layout, null, false);

            TextView courseTitleTxt = cardElementView.findViewById(R.id.courseTitleTxt);
            TextView instructorNameTxt = cardElementView.findViewById(R.id.instructorNameTxt);
            TextView priceTxt = cardElementView.findViewById(R.id.priceTxt);
            TextView ratingTxt = cardElementView.findViewById(R.id.ratingTxt);
            ImageView courseImage = cardElementView.findViewById(R.id.courseImage);
            courseTitleTxt.setText(courseInfo.getTitle());
            instructorNameTxt.setText(courseInfo.getInstructorDetailArrayList().get(0).getName());
            priceTxt.setText(courseInfo.getPrice());
//            ratingTxt.setText(String.valueOf(courseInfo.));

            Glide.with(getContext()).load(courseInfo.getImageLink()).into(courseImage);

//            horizontalScrollView.addView(cardElementView);
            horizontalScrollLL.addView(cardElementView);

            cardElementView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Bundle bundle = new Bundle();
                    bundle.putString("imageLink", courseInfo.getImageLink());
                    bundle.putString("instructor", courseInfo.getInstructorDetailArrayList().get(0).getName());
                    bundle.putString("courseDetail", courseInfo.getHeadline());
                    bundle.putInt("courseId", courseInfo.getCourseId());
                    bundle.putString("courseTitle", courseInfo.getTitle());


                    NavController navController = NavHostFragment.findNavController(fragment);
                    navController.navigate(R.id.courseDetailFragment2,bundle);
//                    NavHostFragment.findNavController(fragment).navigate(R.id.action_homeFragment_to_courseDetailFragment);


                }
            });

        }

    }

}

