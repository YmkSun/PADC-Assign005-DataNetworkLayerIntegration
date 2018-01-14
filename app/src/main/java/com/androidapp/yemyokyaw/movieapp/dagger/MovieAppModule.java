package com.androidapp.yemyokyaw.movieapp.dagger;

import android.content.Context;

import com.androidapp.yemyokyaw.movieapp.MovieApp;
import com.androidapp.yemyokyaw.movieapp.data.model.MovieModel;
import com.androidapp.yemyokyaw.movieapp.mvp.presenters.MovieListPresenter;
import com.androidapp.yemyokyaw.movieapp.network.MovieDataAgent;
import com.androidapp.yemyokyaw.movieapp.network.MovieDataAgentImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by GL-553VD on 1/12/2018.
 */

@Module
public class MovieAppModule {
    private MovieApp mApp;

    public MovieAppModule(MovieApp application) {
        mApp = application;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return mApp.getApplicationContext();
    }

    @Provides
    @Singleton
    public MovieDataAgent provideMovieDataAgent() { return new MovieDataAgentImpl(); }

    @Provides
    @Singleton
    public MovieModel provideMovieModel(Context context) {
        return new MovieModel(context);
    }

    @Provides
    public MovieListPresenter provideMovieListPresenter() {
        return new MovieListPresenter();
    }
}
