package com.example.retrofittesting;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MessageService {


    @GET(".")
    Call<List<Message>> getMessages();
}
