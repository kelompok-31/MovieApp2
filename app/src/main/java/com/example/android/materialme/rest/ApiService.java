package com.example.android.materialme.rest;

import com.example.android.materialme.model.RoodMovieModel;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("popular")
    Call<RoodMovieModel> getData(
            @Query("api_key") String apikey,
            @Query("language") String language,
            @Query("page") String page
    );
}
