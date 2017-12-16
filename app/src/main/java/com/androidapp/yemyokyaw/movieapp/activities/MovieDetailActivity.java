package com.androidapp.yemyokyaw.movieapp.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.androidapp.yemyokyaw.movieapp.R;
import com.androidapp.yemyokyaw.movieapp.adapters.MovieListRvAdapter;
import com.androidapp.yemyokyaw.movieapp.delegates.MovieListDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieDetailActivity extends AppCompatActivity implements MovieListDelegate {

    @BindView(R.id.rv_movie_trailer_images)
    public RecyclerView rvMovieTrailerImages;


    MovieListRvAdapter mMovieListRvAdapter;

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, MovieDetailActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        ButterKnife.bind(this,this);

        mMovieListRvAdapter = new MovieListRvAdapter(getApplicationContext(),this);
        rvMovieTrailerImages.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        rvMovieTrailerImages.setAdapter(mMovieListRvAdapter);
    }

    @Override
    public void onTapped() {
    }
}
