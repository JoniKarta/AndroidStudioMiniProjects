package com.example.bookapptemplate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private BookAdapter bookAdapter;
    private List<BookModel> bookList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initBookAdapter();
        initRecyclerView();
        dummyInput();
        setAdapter();

    }


    private void initBookAdapter(){
        bookAdapter = new BookAdapter(bookList =  new ArrayList<BookModel>());
    }

    private void initRecyclerView(){
        recyclerView = findViewById(R.id.main_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

    }

    private void setAdapter(){
        recyclerView.setAdapter(bookAdapter);
        bookAdapter.notifyDataSetChanged();
    }

    /*
      this.title = title;
        this.author = author;
        this.description = description;
        this.imgUrl = imgUrl;
        this.pages = pages;
        this.reviews = reviews;
        this.drawableImage = drawableImage;
     */
    private void dummyInput(){
        bookList.add(new BookModel(
                "Game Of Throne",
                "by George R.R Martin",
                "",
                "",
                763,
                52,
                R.drawable.book));
        bookList.add(new BookModel(
                "Dog Man",
                "DAV PILKY",
                "",
                "",
                452,
                12,
                R.drawable.book1));
        bookList.add(new BookModel(
                "The Invisible Life",
                "by V.E SCHWAB",
                "",
                "",
                125,
                3,
                R.drawable.book2));
        bookList.add(new BookModel(
                "Harry Potter",
                "J.K ROWLING",
                "",
                "",
                814,
                112,
                R.drawable.book3));
        bookList.add(new BookModel(
                "One Vote Away",
                "by TED CRUZ",
                "",
                "",
                453,
                12,
                R.drawable.book4));
    }
}