package com.example.android.materialme;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    private TextView Titlemovie;
    private ImageView moviedetail;
    private TextView synopsis;
    private TextView yearmovie;
    private TextView rating;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initView();

        //getSupportActionBar().setTitle(getIntent().getStringExtra("titlemovie"));
        Titlemovie.setText(getIntent().getStringExtra("titlemovie"));
        yearmovie.setText(getIntent().getStringExtra("yearmovie"));
        rating.setText(getIntent().getStringExtra("voteaverage"));
        synopsis.setText(getIntent().getStringExtra("synopsis"));
        Glide.with(getApplicationContext()).load(getIntent().getStringExtra("PosterPath")).error(R.drawable.ic_reset)
                .override(512, 512)
                .into(moviedetail);

    }

    private void initView(){
        moviedetail = findViewById(R.id.moviedetail);
        Titlemovie = findViewById(R.id.titlemovie);
        synopsis = findViewById(R.id.synopsis);
        yearmovie = findViewById(R.id.yearmovie);
        rating = findViewById(R.id.rating);
    }
}