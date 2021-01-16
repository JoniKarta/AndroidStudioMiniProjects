package com.example.retrofittesting;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class MessageViewModel extends ViewModel {

    private MessageRepository messageRepository;

    public MessageViewModel() {
        messageRepository = MessageRepository.getInstance();
    }

    public LiveData<List<Message>> getMessages() {
        return messageRepository.getMessages();
    }


}
