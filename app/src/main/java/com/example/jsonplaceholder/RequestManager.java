package com.example.jsonplaceholder;

import android.content.Context;

import com.example.jsonplaceholder.Api.JSONPlaceholder;
import com.example.jsonplaceholder.Listener.OnFetchDataListener;
import com.example.jsonplaceholder.Modeal.Post;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RequestManager {

    private final Context context;
    private OnFetchDataListener dataListener;

    public RequestManager(Context context, MainActivity dataListener) {
        this.context = context;
        this.dataListener = (OnFetchDataListener) dataListener;
    }

    public void fetchDataFromAPI() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JSONPlaceholder jsonPlaceholder = retrofit.create(JSONPlaceholder.class);
        Call<List<Post>> call = jsonPlaceholder.getPost();
       call.enqueue(new Callback<List<Post>>() {
           @Override
           public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
               if (!response.isSuccessful()) {
                   String errorMessage = "Response Code: " + response.code();
                   notifyFetchFailed(errorMessage);
               } else {
                   List<Post> postList = response.body();
                   if (postList != null) {
                       notifyDataFetched(postList);
                   } else {
                       String errorMessage = "No data available";
                       notifyFetchFailed(errorMessage);
                   }
               }
           }

           @Override
           public void onFailure(Call<List<Post>> call, Throwable t) {
               String errorMessage = "Request failed: " + t.getMessage();
               notifyFetchFailed(errorMessage);
           }
       });

    }
    private void notifyDataFetched(List<Post> postList) {
        if (dataListener != null) {
            dataListener.onDataFetched(postList);
        }
    }

    private void notifyFetchFailed(String errorMessage) {
        if (dataListener != null) {
            dataListener.onFetchFailed(errorMessage);
        }
    }

}
