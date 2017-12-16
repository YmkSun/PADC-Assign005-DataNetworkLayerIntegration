package com.androidapp.yemyokyaw.movieapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidapp.yemyokyaw.movieapp.R;
import com.androidapp.yemyokyaw.movieapp.delegates.MovieListDelegate;
import com.androidapp.yemyokyaw.movieapp.viewholders.MovieTrailerViewHolder;

/**
 * Created by yemyokyaw on 12/16/17.
 */

public class MovieTrailerAdapter extends RecyclerView.Adapter<MovieTrailerViewHolder> {

    private LayoutInflater mLayoutInflator;
    private MovieListDelegate mNewsItemDelegate;

    public MovieTrailerAdapter(Context context, MovieListDelegate newsItemDelegate) {
        mLayoutInflator = LayoutInflater.from(context);
        mNewsItemDelegate = newsItemDelegate;
    }

    @Override
    public MovieTrailerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View newsItemView = mLayoutInflator.inflate(R.layout.view_movie_trailer_detail, parent, false);
        return new MovieTrailerViewHolder(newsItemView, mNewsItemDelegate);
    }

    @Override
    public void onBindViewHolder(MovieTrailerViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
