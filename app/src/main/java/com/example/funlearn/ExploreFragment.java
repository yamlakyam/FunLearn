package com.example.funlearn;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
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
import com.example.funlearn.Util.Constants;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;
import java.util.Set;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ExploreFragment extends Fragment {
    HorizontalScrollView horizontalScrollView;
    LinearLayout horizontalScrollLL;
    LinearLayout firstHorizontalLL;

    public static ArrayList<CourseInfo> courseInfoArrayList;

    Fragment fragment;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_explore, container, false);

        fragment = this;

        horizontalScrollView = view.findViewById(R.id.horizontalScrollViewExplore);
        horizontalScrollLL = view.findViewById(R.id.horizontalScrollLL);
        firstHorizontalLL = view.findViewById(R.id.firstHorizontalLL);

        String username = "KWr09PPO6cuarAQ23r22fUCTMTJluKIpkheoN3eE";
        String password = "55iS1BiEsxIfx3osg9MXlHhKW1AOhzWaXcNbAjzJDssqFtYQpYxAwZ4xvHqXZ94PgbdDVEjIsMXjL7NHh0y0pWdweTvTzE9UhkSA04nS4UCdsmiuSqDruR0ATUaKVI9J";

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new BasicAuthInterceptor(username, password)).build();

//            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constants.BASE_URL).client(client).addConverterFactory(GsonConverterFactory.create()).build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        Call<AllUdemyData> call = apiInterface.getCourses();

        call.enqueue(new Callback<AllUdemyData>() {
            @Override
            public void onResponse(Call<AllUdemyData> call, Response<AllUdemyData> response) {

                courseInfoArrayList = new ArrayList<>();
                courseInfoArrayList.addAll(response.body().getCourseInfoArrayList());
                Log.i("All courses", courseInfoArrayList.get(0).getHeadline() + "");
                drawCourseCards();
            }

            @Override
            public void onFailure(Call<AllUdemyData> call, Throwable t) {
            }
        });

        addFavoritePicks();

        return view;
    }

    private void drawCourseCards() {
        for (int i = 0; i < courseInfoArrayList.size(); i++) {
            CourseInfo courseInfo = courseInfoArrayList.get(i);

            if (getContext() != null) {
                LayoutInflater courseCardInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View cardElementView = courseCardInflater.inflate(R.layout.course_layout, null, false);

                TextView courseTitleTxt = cardElementView.findViewById(R.id.courseTitleTxt);
                TextView instructorNameTxt = cardElementView.findViewById(R.id.instructorNameTxt);
                TextView priceTxt = cardElementView.findViewById(R.id.priceTxt);
                TextView ratingTxt = cardElementView.findViewById(R.id.ratingTxt);
                MaterialCardView wishCourse = cardElementView.findViewById(R.id.wishCourseCard);
                ImageView courseImage = cardElementView.findViewById(R.id.courseImage);
                courseTitleTxt.setText(courseInfo.getTitle());
                instructorNameTxt.setText(courseInfo.getInstructorDetailArrayList().get(0).getName());
                priceTxt.setText(courseInfo.getPrice());
//            ratingTxt.setText(String.valueOf(courseInfo.));
                Glide.with(getContext()).load(courseInfo.getImageLink()).into(courseImage);
                if (Constants.wishList.contains(courseInfo.getCourseId())) {
                    wishCourse.setStrokeWidth(10);
                    wishCourse.setCardElevation(2f);
                    wishCourse.setStrokeColor(Color.parseColor("#ff6765"));
                }

//            horizontalScrollView.addView(cardElementView);
                wishCourse.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        wishCourse.setStrokeWidth(10);
                        wishCourse.setCardElevation(2f);
                        wishCourse.setStrokeColor(Color.parseColor("#ff6765"));
                        Constants.wishList.add(courseInfo.getCourseId());

                    }
                });

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

                        Intent intent = new Intent(requireActivity(), CourseDetailActivity.class);
                        intent.putExtra("imageLink", courseInfo.getImageLink());
                        intent.putExtra("instructor", courseInfo.getInstructorDetailArrayList().get(0).getName());
                        intent.putExtra("courseDetail", courseInfo.getHeadline());
                        intent.putExtra("courseId", courseInfo.getCourseId());
                        intent.putExtra("courseTitle", courseInfo.getTitle());
                        startActivity(intent);
                    }
                });
            }

        }
    }

    private void addFavoritePicks() {
        SharedPreferences prefs = requireActivity().getSharedPreferences("FAVORITE_LIST", Context.MODE_PRIVATE);
        Set<String> favoritePickSet = prefs.getStringSet("favorite_set", null);

        Log.i("TAG", favoritePickSet.toString());

        ArrayList<String> favoritePickList = new ArrayList<>(favoritePickSet);

        firstHorizontalLL.removeAllViews();
        for (int i = 0; i < favoritePickList.size(); i++) {

            LayoutInflater courseCardInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View favoritePick = courseCardInflater.inflate(R.layout.category_layout, null, false);
            ImageView favPickImg = favoritePick.findViewById(R.id.picksImage);
            TextView favPickTxt = favoritePick.findViewById(R.id.picksTitle);

            View view = new View(requireContext());
            view.setLayoutParams(new LinearLayout.LayoutParams(10, LinearLayout.LayoutParams.MATCH_PARENT));

            String fav = favoritePickList.get(i);

            switch (fav) {
                case "finance":
                    favPickImg.setImageDrawable(getResources().getDrawable(R.drawable.finance));
                    favPickTxt.setText("Finance");
                    firstHorizontalLL.addView(favoritePick);
                    firstHorizontalLL.addView(view);
                    break;
                case "coding":
                    favPickImg.setImageDrawable(getResources().getDrawable(R.drawable.desktop));
                    favPickTxt.setText("Coding");
                    firstHorizontalLL.addView(favoritePick);
                    firstHorizontalLL.addView(view);

                    break;
                case "business":
                    favPickImg.setImageDrawable(getResources().getDrawable(R.drawable.briefcase));
                    favPickTxt.setText("Business");
                    firstHorizontalLL.addView(favoritePick);
                    firstHorizontalLL.addView(view);

                    break;

                case "lifestyle":
                    favPickImg.setImageDrawable(getResources().getDrawable(R.drawable.lifestyle));
                    favPickTxt.setText("LifeStyle");
                    firstHorizontalLL.addView(favoritePick);
                    firstHorizontalLL.addView(view);

                    break;

                case "health":
                    favPickImg.setImageDrawable(getResources().getDrawable(R.drawable.healthcare));
                    favPickTxt.setText("Health");
                    firstHorizontalLL.addView(favoritePick);
                    firstHorizontalLL.addView(view);

                    break;

                case "music":
                    favPickImg.setImageDrawable(getResources().getDrawable(R.drawable.musical));
                    favPickTxt.setText("Music");
                    firstHorizontalLL.addView(favoritePick);
                    firstHorizontalLL.addView(view);

                    break;

                case "marketing":
                    favPickImg.setImageDrawable(getResources().getDrawable(R.drawable.advertising));
                    favPickTxt.setText("Marketing");
                    firstHorizontalLL.addView(favoritePick);
                    firstHorizontalLL.addView(view);

                    break;

                case "design":
                    favPickImg.setImageDrawable(getResources().getDrawable(R.drawable.measuring));
                    favPickTxt.setText("Design");
                    firstHorizontalLL.addView(favoritePick);
                    firstHorizontalLL.addView(view);

                    break;

                case "personalDev":
                    favPickImg.setImageDrawable(getResources().getDrawable(R.drawable.goal));
                    favPickTxt.setText("Personal Devt");
                    firstHorizontalLL.addView(favoritePick);
                    firstHorizontalLL.addView(view);

                    break;

                default:
                    Log.i("DONOTHING", "addFavoritePicks: ");


            }

        }

    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("courses on wishlist", Constants.wishList.toString());
    }
}

