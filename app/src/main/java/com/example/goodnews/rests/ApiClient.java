package com.example.goodnews.rests;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
/**
 * The ApiClient class.
 * @author Kate Belson
 */
public class ApiClient {
    public static final String BASE_URL = "https://newsapi.org/v2/";
    private static Retrofit retrofit = null;
    /**
     * Gets the client.
     * @author Kate Belson
     * @return retrofit.
     */
    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}