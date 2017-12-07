package com.androidapp.yemyokyaw.movieapp;

import android.app.Application;

import com.androidapp.yemyokyaw.movieapp.data.model.MovieModel;

/**
 * Created by yemyokyaw on 12/5/17.
 */

public class MovieApp extends Application {

    public static final String LOG_TAG = "MovieApp";

    @Override
    public void onCreate() {
        super.onCreate();
        MovieModel.getInstance().startLoadingMovie();
    }
}
