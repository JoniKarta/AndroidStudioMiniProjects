package com.example.retrofittesting;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class RetrofitService {


    private static final String BASE_URL = "https://api.mocki.io/v1/8c35d74e/";
    private static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    public static MessageService messageService() {
        return retrofit.create(MessageService.class);
    }
}
