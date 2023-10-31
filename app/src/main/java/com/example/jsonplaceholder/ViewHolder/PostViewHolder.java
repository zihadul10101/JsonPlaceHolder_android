package com.example.jsonplaceholder.ViewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jsonplaceholder.R;

public class PostViewHolder extends RecyclerView.ViewHolder {
   public TextView userId;
    public TextView id;
  public   TextView title;
  public   TextView body;
  public   CardView cardView;
    public PostViewHolder(@NonNull View itemView) {
        super(itemView);
        userId=itemView.findViewById(R.id.userId);
        id=itemView.findViewById(R.id.id);
        title=itemView.findViewById(R.id.title);
        body=itemView.findViewById(R.id.body);
        cardView = itemView.findViewById(R.id.main_container);
    }
}
