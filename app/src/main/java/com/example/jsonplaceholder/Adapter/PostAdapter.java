package com.example.jsonplaceholder.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jsonplaceholder.Modeal.Post;
import com.example.jsonplaceholder.R;
import com.example.jsonplaceholder.ViewHolder.PostViewHolder;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostViewHolder> {

    Context context;
    List<Post> postList;
    public PostAdapter(Context context, List<Post> posts){
        this.context = context;
        this.postList = posts;
    }


    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        Post post=postList.get(position);
        holder.id.setText((post.getId()));
        holder.userId.setText((post.getUserId()));
        holder.title.setText((post.getTitle()));
        holder.body.setText(post.getBody());
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }
}
