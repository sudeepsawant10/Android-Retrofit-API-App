package com.example.retrofitapiapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter {
    Context context;
    ArrayList<Post> postArrayList;

    public PostAdapter(Context context, ArrayList<Post> postArrayList) {
        this.context = context;
        this.postArrayList = postArrayList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rv_post_item_design, parent,false );
        return new PostItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        PostItemViewHolder viewHolder = (PostItemViewHolder) holder;
        Post post = postArrayList.get(position);
        viewHolder.name.setText(post.getTitle());
        viewHolder.email.setText(post.getBody());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class PostItemViewHolder extends RecyclerView.ViewHolder {
        TextView name, email;

        public PostItemViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.rvUserName);
            email = itemView.findViewById(R.id.rvUserEmail);
        }
    }
}
