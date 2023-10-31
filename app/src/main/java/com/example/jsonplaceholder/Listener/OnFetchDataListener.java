package com.example.jsonplaceholder.Listener;

import com.example.jsonplaceholder.Modeal.Post;

import java.util.List;

public interface OnFetchDataListener {
    void onDataFetched(List<Post> postList);

    void onFetchFailed(String errorMessage);
}
