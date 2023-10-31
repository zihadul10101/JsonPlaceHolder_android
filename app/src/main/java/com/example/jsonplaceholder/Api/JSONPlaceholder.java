package com.example.jsonplaceholder.Api;

import com.example.jsonplaceholder.Modeal.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JSONPlaceholder {
    @GET("posts")
  Call<List<Post>> getPost();
}
