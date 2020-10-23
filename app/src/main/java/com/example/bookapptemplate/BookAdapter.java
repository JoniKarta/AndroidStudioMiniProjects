package com.example.bookapptemplate;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder>  {

    private List<BookModel> listBook;

    public BookAdapter(List<BookModel> listBook) {
        this.listBook = listBook;
    }

    public static class BookViewHolder extends RecyclerView.ViewHolder {

        ImageView bookImage;
        TextView title;
        TextView author;
        RatingBar rating;
        TextView pages;
        TextView reviews;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            bookImage = itemView.findViewById(R.id.item_layout_book_image);
            title = itemView.findViewById(R.id.item_layout_title);
            author = itemView.findViewById(R.id.item_layout_author);
            rating = itemView.findViewById(R.id.item_layout_rating_bar);
            pages = itemView.findViewById(R.id.item_layout_pages);
            reviews = itemView.findViewById(R.id.item_layout_reviews);
        }

    }


    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent,false);
        return new BookViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {

        // Load an image to it's corresponding holder
        Glide.with(holder.bookImage.getContext())
                .load(listBook.get(position).getDrawableImage())
                .into(holder.bookImage);
        holder.title.setText(listBook.get(position).getTitle());
        holder.author.setText(listBook.get(position).getAuthor());
        holder.pages.setText(listBook.get(position).getPages());
        holder.reviews.setText(listBook.get(position).getReviews());

    }

    @Override
    public int getItemCount() {
        return listBook.size();
    }


}
