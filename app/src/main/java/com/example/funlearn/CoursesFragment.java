package com.example.funlearn;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.funlearn.Models.AllUdemyData;
import com.example.funlearn.Models.CourseInfo;
import com.example.funlearn.Retrofit.ApiInterface;
import com.example.funlearn.Retrofit.BasicAuthInterceptor;
import com.example.funlearn.Util.Constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CoursesFragment extends Fragment {

    ArrayList<String> categoriesOnTheAPI;
    HashMap<String, String> categoriesMap;
    LinearLayout favoriteCourseLayout;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_courses, container, false);

        favoriteCourseLayout = view.findViewById(R.id.favoriteCourseLayout);

        categoriesOnTheAPI = new ArrayList<>();
        getFavoriteCategoryList();

        categoriesMap = new HashMap<>();
        for (int i = 0; i < categoriesOnTheAPI.size(); i++) {
            categoriesMap.put("category", categoriesOnTheAPI.get(i));
        }

        getCourseDetail();

        return view;
    }

    public void getFavoriteCategoryList() {
        SharedPreferences prefs = requireActivity().getSharedPreferences("FAVORITE_LIST", Context.MODE_PRIVATE);
        Set<String> favoritePickSet = prefs.getStringSet("favorite_set", null);
        ArrayList<String> favoritePickList = new ArrayList<>(favoritePickSet);

        for (int i = 0; i < favoritePickList.size(); i++) {
            String fav = favoritePickList.get(i);
            switch (fav) {
                case "finance":
                    categoriesOnTheAPI.add("Finance & Accounting");
                    break;
                case "coding":
                    categoriesOnTheAPI.add("Development");
                    break;
                case "business":
                    categoriesOnTheAPI.add("Business");
                    break;
                case "lifestyle":
                    categoriesOnTheAPI.add("Lifestyle");
                    break;
                case "health":
                    categoriesOnTheAPI.add("Health & Fitness");
                    break;
                case "music":
                    categoriesOnTheAPI.add("Music");
                    break;
                case "marketing":
                    categoriesOnTheAPI.add("Marketing");
                    break;
                case "design":
                    categoriesOnTheAPI.add("Design");
                    break;
                case "personalDev":
                    categoriesOnTheAPI.add("Personal Development");
                    break;

                default:
                    Log.i("DONOTHING", "addFavoritePicks: ");


            }

        }
    }

    public void getCourseDetail() {
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new BasicAuthInterceptor(Constants.username, Constants.password)).build();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constants.BASE_URL).client(client).addConverterFactory(GsonConverterFactory.create()).build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<AllUdemyData> call = apiInterface.getFilteredCourses(categoriesMap);
        call.enqueue(new Callback<AllUdemyData>() {
            @Override
            public void onResponse(Call<AllUdemyData> call, Response<AllUdemyData> response) {
                Log.i("Filterd-Courses", response.body().getCourseInfoArrayList().toString());

                ArrayList<CourseInfo> courseInfoArrayList = response.body().getCourseInfoArrayList();

                for (int i = 0; i < courseInfoArrayList.size(); i++) {
                    CourseInfo courseInfo = courseInfoArrayList.get(i);
                    Log.i("Course info at " + i, courseInfo + "");
                    drawCourseCards(courseInfo);
                }
            }

            @Override
            public void onFailure(Call<AllUdemyData> call, Throwable t) {

            }
        });
    }

    public void drawCourseCards(CourseInfo courseInfo) {
        LayoutInflater favCourseCardInflator = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View favCourseLayout = favCourseCardInflator.inflate(R.layout.my_course_layout, null, false);
        ImageView courseImage = favCourseLayout.findViewById(R.id.coursePicture);
        TextView courseTitle = favCourseLayout.findViewById(R.id.courseTitle);
        TextView instructorsName = favCourseLayout.findViewById(R.id.instructorsName);
        TextView coursePrice = favCourseLayout.findViewById(R.id.coursePrice);
        Glide.with(getContext()).load(courseInfo.getImageLink()).into(courseImage);
        courseTitle.setText(courseInfo.getTitle());
        instructorsName.setText(courseInfo.getInstructorDetailArrayList().get(0).getName());
        coursePrice.setText(courseInfo.getPrice());
        favoriteCourseLayout.addView(favCourseLayout);
    }
}