package com.androidapp.yemyokyaw.movieapp.adapters;

import android.content.Context;
import android.graphics.Movie;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidapp.yemyokyaw.movieapp.R;
import com.androidapp.yemyokyaw.movieapp.delegates.MovieListDelegate;
import com.androidapp.yemyokyaw.movieapp.models.MovieData;
import com.androidapp.yemyokyaw.movieapp.models.MovieListData;
import com.androidapp.yemyokyaw.movieapp.viewholders.MovieListViewHolder;

import java.util.List;

/**
 * Created by yemyokyaw on 12/5/17.
 */

public class MovieListRvAdapter extends RecyclerView.Adapter<MovieListViewHolder> {

    private LayoutInflater mLayoutInflater;
    private MovieListDelegate mMovieListDelegate;
    private List<MovieData> movieList;

    public MovieListRvAdapter(Context context, MovieListDelegate mlDelegate) {
        mLayoutInflater = LayoutInflater.from(context);
        mMovieListDelegate = mlDelegate;
        movieList = new MovieListData().getList();
    }

    @Override
    public MovieListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.view_movie_data, parent, false);
        return new MovieListViewHolder(view, mMovieListDelegate);
    }

    @Override
    public void onBindViewHolder(MovieListViewHolder holder, int position) {
        holder.bindData(movieList.get(position));
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }


}
