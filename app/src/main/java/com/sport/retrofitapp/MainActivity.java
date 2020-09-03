package com.sport.retrofitapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Item> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=(RecyclerView) findViewById(R.id.recycler);
     //   recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        getData();
    }

    private void getData(){
        Call<PostList> postlist=Api.getPostserivice().getpost();
        postlist.enqueue(new Callback<PostList>() {
            @Override
            public void onResponse(Call<PostList> call, Response<PostList> response) {
                PostList list=response.body();

                try {
                    recyclerView.setAdapter(new RecyclerAdapter(MainActivity.this,list.getItems()));
                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(),""+e.getMessage(),Toast.LENGTH_LONG).show();
                }

                Toast.makeText(getApplicationContext(),"Success"+new RecyclerAdapter(MainActivity.this,list.getItems()), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<PostList> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Something went Wrong", Toast.LENGTH_LONG).show();

            }
        });
    }
}