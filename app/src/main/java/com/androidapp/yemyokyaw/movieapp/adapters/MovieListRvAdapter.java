package com.androidapp.yemyokyaw.movieapp.adapters;

import android.content.Context;
import android.graphics.Movie;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidapp.yemyokyaw.movieapp.R;
import com.androidapp.yemyokyaw.movieapp.data.vo.MovieVO;
import com.androidapp.yemyokyaw.movieapp.delegates.MovieListDelegate;
import com.androidapp.yemyokyaw.movieapp.viewholders.MovieListViewHolder;

/**
 * Created by yemyokyaw on 12/5/17.
 */

public class MovieListRvAdapter extends BaseRecyclerAdapter<MovieListViewHolder,MovieVO> {

    private MovieListDelegate mMovieListDelegate;

    public MovieListRvAdapter(Context context, MovieListDelegate mlDelegate) {
        super(context);
        mMovieListDelegate = mlDelegate;
    }

    @Override
    public MovieListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflator.inflate(R.layout.view_movie_data, parent, false);
        return new MovieListViewHolder(view, mMovieListDelegate);
    }

}
