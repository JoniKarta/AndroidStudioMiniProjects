package com.example.retrofittesting;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MessageRepository {

    private static MessageService messageService;
    private static MessageRepository messageRepository;
    private MessageRepository() {
        messageService = RetrofitService.messageService();
    }

    public static MessageRepository getInstance() {
        if(messageRepository == null) {
            messageRepository = new MessageRepository();
        }
        return messageRepository;
    }

    public MutableLiveData<List<Message>> getMessages() {
        MutableLiveData<List<Message>> mutableLiveData = new MutableLiveData<>();
        Call<List<Message>> call = messageService.getMessages();
        call.enqueue(new Callback<List<Message>>() {
            @Override
            public void onResponse(Call<List<Message>> call, Response<List<Message>> response) {
                mutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Message>> call, Throwable t) {
                mutableLiveData.postValue(null);
            }
        });
        return mutableLiveData;
    }
}
