package com.example.retrofittesting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private Button button;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private MessageAdapter messageAdapter;
    private MessageViewModel messageViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        messageViewModel = new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(MessageViewModel.class);
        initRecyclerView();
        messageViewModel.getMessages().observe(this, list -> {
            messageAdapter.setList(list);
            messageAdapter.notifyDataSetChanged();
        });

        messageAdapter.setOnItemClick(position -> Toast.makeText(MainActivity.this, "Position: " + position, Toast.LENGTH_SHORT).show());

    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        messageAdapter = new MessageAdapter(messageViewModel.getMessages().getValue() != null ? messageViewModel.getMessages().getValue() : new ArrayList<>());
        recyclerView.setAdapter(messageAdapter);


    }
}