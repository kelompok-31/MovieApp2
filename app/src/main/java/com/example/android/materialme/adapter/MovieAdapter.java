package com.example.android.materialme.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.android.materialme.DetailActivity;
import com.example.android.materialme.R;
import com.example.android.materialme.model.ResultsItem;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private ArrayList<ResultsItem> resultsItems;
    private Context context;


    public MovieAdapter(ArrayList<ResultsItem> resultsItems, Context context) {
        this.resultsItems = resultsItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.title.setText(resultsItems.get(position).getTitle());
        holder.year.setText(resultsItems.get(position).getReleaseDate());
        holder.subTitle.setText(resultsItems.get(position).getOverview());
        Glide.with(context).load(resultsItems.get(position).getBackdropPath()).error(R.drawable.ic_reset)
                .override(512, 512)
                .into(holder.movieImage);

        holder.cardklick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("titlemovie", resultsItems.get(position).getTitle());
                intent.putExtra("yearmovie", resultsItems.get(position).getReleaseDate());
                intent.putExtra("rating", resultsItems.get(position).getVoteAverage());
                intent.putExtra("synopsis", resultsItems.get(position).getOverview());
                intent.putExtra("PosterPath", resultsItems.get(position).getPosterPath());
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return resultsItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView movieImage;
        private TextView title;
        private TextView year;
        private TextView subTitle;
        private CardView cardklick;

        public ViewHolder(View itemView) {
            super(itemView);
            movieImage = itemView.findViewById(R.id.movieImage);
            title = itemView.findViewById(R.id.title);
            year = itemView.findViewById(R.id.year);
            subTitle = itemView.findViewById(R.id.subTitle);
            cardklick = itemView.findViewById(R.id.cardklick);
        }
    }
}
