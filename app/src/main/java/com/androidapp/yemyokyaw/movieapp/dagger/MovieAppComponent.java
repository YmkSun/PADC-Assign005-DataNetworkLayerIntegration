package com.androidapp.yemyokyaw.movieapp.dagger;

import com.androidapp.yemyokyaw.movieapp.MovieApp;
import com.androidapp.yemyokyaw.movieapp.activities.MovieListActivity;
import com.androidapp.yemyokyaw.movieapp.data.model.MovieModel;
import com.androidapp.yemyokyaw.movieapp.mvp.presenters.MovieListPresenter;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;

/**
 * Created by GL-553VD on 1/12/2018.
 */

@Component(modules={MovieAppModule.class,UtilsModule.class})
@Singleton
public interface MovieAppComponent {
    void inject(MovieApp app);

    void inject(MovieModel movieModel);

    void inject(MovieListPresenter movieListPresenter);

    void inject(MovieListActivity movieListActivity);
}
