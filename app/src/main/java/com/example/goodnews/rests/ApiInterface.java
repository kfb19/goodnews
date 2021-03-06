package com.example.goodnews.rests;

import com.example.goodnews.model.ResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
/**
 * The ApiClient interface.
 * @author Kate Belson
 */
public interface ApiInterface {
    @GET("top-headlines")
    Call<ResponseModel> getLatestNews(@Query("country") String country, @Query("apiKey") String apiKey);
}
