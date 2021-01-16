package com.example.retrofittesting;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {
    interface OnItemClick {
        void onItemClick(int position);
    }


    private List<Message> list;
    private OnItemClick onItemClick;
    public MessageAdapter(List<Message> list) {
        this.list = list;
    }

    public void setList(List<Message> list) {
        this.list = list;
    }

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new MessageViewHolder(v, onItemClick);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        holder.textView.setText(list.get(position).getMessage());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public static class MessageViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public MessageViewHolder(@NonNull View itemView, OnItemClick onItemClick) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            itemView.setOnClickListener(v -> {
                if(onItemClick != null){
                    int position = getAdapterPosition();
                    onItemClick.onItemClick(position);
                }
            });
        }
    }
}
