package com.example.jsonplaceholder;

import static android.content.ContentValues.TAG;
import static com.example.jsonplaceholder.R.id.recyclerView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.jsonplaceholder.Adapter.PostAdapter;
import com.example.jsonplaceholder.Api.JSONPlaceholder;
import com.example.jsonplaceholder.Listener.OnFetchDataListener;
import com.example.jsonplaceholder.Modeal.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements OnFetchDataListener {
    RecyclerView recyclerView;
     RequestManager requestManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        requestManager = new RequestManager((Context) this, MainActivity.this);
        requestManager.fetchDataFromAPI();


    }
    public void onDataFetched(List<Post> postList) {
        // Handle the fetched data here
        PostAdapter postAdapter = new PostAdapter(this, postList);
        recyclerView.setAdapter(postAdapter);
    }
    public void onFetchFailed(String errorMessage) {
        // Handle the fetch failure here
        // You can display an error message or take other actions as needed
    }
}