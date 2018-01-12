package com.androidapp.yemyokyaw.movieapp;

import android.app.Application;
import android.content.Context;

import com.androidapp.yemyokyaw.movieapp.dagger.DaggerMovieAppComponent;
import com.androidapp.yemyokyaw.movieapp.dagger.MovieAppComponent;
import com.androidapp.yemyokyaw.movieapp.dagger.MovieAppModule;
import com.androidapp.yemyokyaw.movieapp.dagger.UtilsModule;
import com.androidapp.yemyokyaw.movieapp.data.model.MovieModel;

import javax.inject.Inject;

/**
 * Created by yemyokyaw on 12/5/17.
 */

public class MovieApp extends Application {

    public static final String LOG_TAG = "MovieApp";
    private MovieAppComponent mMovieAppComponent;

    @Inject
    Context mContext;

    @Inject
    MovieModel mMovieModel;

    @Override
    public void onCreate() {
        super.onCreate();
        mMovieAppComponent = initDagger(); //dagger init
        mMovieAppComponent.inject(this); //register consumer
        mMovieModel.startLoadingMovie(mContext);
    }

    private MovieAppComponent initDagger() {
        //return null;
        return DaggerMovieAppComponent.builder()
                .movieAppModule(new MovieAppModule(this))
                .utilsModule(new UtilsModule())
                .build();

    }

    public MovieAppComponent getMovieAppComponent() {
        return mMovieAppComponent;
    }
}
