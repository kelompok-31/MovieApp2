/*
 * Copyright (C) 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.materialme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.android.materialme.adapter.MovieAdapter;
import com.example.android.materialme.alarm.AlarmActivity;
import com.example.android.materialme.model.ResultsItem;
import com.example.android.materialme.model.RoodMovieModel;
import com.example.android.materialme.rest.ApiConfig;
import com.example.android.materialme.rest.ApiService;

import java.util.ArrayList;

import javax.xml.transform.Result;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/***
 * Main Activity for the Material Me app, a mock sports news application
 * with poor design choices.
 */
public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<ResultsItem> resultsItems;
    private MovieAdapter movieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        resultsItems = new ArrayList();

        getData();
    }

    private void getData() {
        ApiService apiService = ApiConfig.getApiService();
        apiService.getData("0dde3e9896a8c299d142e214fcb636f8", "en-US", "1")
                .enqueue(new Callback<RoodMovieModel>() {
                    @Override
                    public void onResponse(Call<RoodMovieModel> call, Response<RoodMovieModel> response) {
                        if (response.isSuccessful()) {
                            resultsItems = (ArrayList<ResultsItem>) response.body().getResults();
                            movieAdapter = new MovieAdapter(resultsItems, getApplicationContext());
                            recyclerView.setAdapter(movieAdapter);
                            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

                        }
                    }

                    @Override
                    public void onFailure(Call<RoodMovieModel> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    ;

    private void initView() {
        recyclerView = findViewById(R.id.recyclerView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.about) {
            Intent about = new Intent(MainActivity.this, AboutUs.class);
            startActivity(about);
            return true;
        } else if(item.getItemId() == R.id.alarm) {
            Intent alarm = new Intent(MainActivity.this, AlarmActivity.class);
            startActivity(alarm);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}