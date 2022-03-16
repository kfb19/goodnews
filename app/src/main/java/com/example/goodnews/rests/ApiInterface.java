package com.example.goodnews.rests;

import com.example.goodnews.model.ResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
public interface APIInterface { //made not public
    @GET("top-headlines")
    Call<ResponseModel> getLatestNews(@Query("sources") String source, @Query("apiKey") String apiKey);
}
