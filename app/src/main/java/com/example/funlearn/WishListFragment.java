package com.example.funlearn;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.funlearn.Models.CourseInfo;
import com.example.funlearn.Retrofit.ApiInterface;
import com.example.funlearn.Retrofit.BasicAuthInterceptor;
import com.example.funlearn.Util.Constants;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WishListFragment extends Fragment {

    LinearLayout wishListLayout;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wish_list, container, false);
        wishListLayout = view.findViewById(R.id.wishListLayout);

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new BasicAuthInterceptor(Constants.username, Constants.password)).build();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constants.BASE_URL).client(client).addConverterFactory(GsonConverterFactory.create()).build();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        for (int i = 0; i < Constants.wishList.size(); i++) {

            Call<CourseInfo> call = apiInterface.getCourseDetail(Constants.wishList.get(i));
            call.enqueue(new Callback<CourseInfo>() {
                @Override
                public void onResponse(Call<CourseInfo> call, Response<CourseInfo> response) {
                    CourseInfo courseInfo = response.body();

                    LayoutInflater wishListInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    View wishLayout = wishListInflater.inflate(R.layout.my_course_layout, null, false);

                    ImageView courseImage = wishLayout.findViewById(R.id.coursePicture);
                    TextView courseTitle = wishLayout.findViewById(R.id.courseTitle);
                    TextView instructorsName = wishLayout.findViewById(R.id.instructorsName);
                    TextView coursePrice = wishLayout.findViewById(R.id.coursePrice);


                    Glide.with(getContext()).load(courseInfo.getImageLink()).into(courseImage);
                    courseTitle.setText(courseInfo.getTitle());
                    instructorsName.setText(courseInfo.getInstructorDetailArrayList().get(0).getName());
                    coursePrice.setText(courseInfo.getPrice());

                    View view = new View(getContext());
                    view.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 10));

                    wishListLayout.addView(wishLayout);
                    wishListLayout.addView(view);

                }

                @Override
                public void onFailure(Call<CourseInfo> call, Throwable t) {

                }
            });
        }

        return view;
    }
}