package com.example.funlearn;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.funlearn.Models.AllUdemyData;
import com.example.funlearn.Models.CourseInfo;
import com.example.funlearn.R;
import com.example.funlearn.Retrofit.ApiInterface;
import com.example.funlearn.Retrofit.BasicAuthInterceptor;
import com.example.funlearn.Retrofit.RetrofitClientInstance;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeFragment extends Fragment {

    //    private static final String BASE_URL = "https://www.udemy.com/api-2.0/courses";
    private static final String BASE_URL = "https://www.udemy.com/api-2.0/";

    public static ArrayList<CourseInfo> courseInfoArrayList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

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

            }


            @Override
            public void onFailure(Call<AllUdemyData> call, Throwable t) {

            }
        });

        return view;
    }
}