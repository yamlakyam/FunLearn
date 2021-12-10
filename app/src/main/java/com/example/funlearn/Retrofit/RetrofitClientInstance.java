package com.example.funlearn.Retrofit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {

    private static Retrofit retrofit;
    private static final String BASE_URL = "https://www.udemy.com/api-2.0/courses";

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            String username="KWr09PPO6cuarAQ23r22fUCTMTJluKIpkheoN3eE";
            String password="55iS1BiEsxIfx3osg9MXlHhKW1AOhzWaXcNbAjzJDssqFtYQpYxAwZ4xvHqXZ94PgbdDVEjIsMXjL7NHh0y0pWdweTvTzE9UhkSA04nS4UCdsmiuSqDruR0ATUaKVI9J";

            OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new BasicAuthInterceptor(username, password)).build();

//            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).client(client).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }

}
