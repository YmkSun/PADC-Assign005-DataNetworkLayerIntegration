package com.androidapp.yemyokyaw.movieapp.mvp.presenters;

import android.content.Context;

import com.androidapp.yemyokyaw.movieapp.MovieApp;
import com.androidapp.yemyokyaw.movieapp.data.model.MovieModel;
import com.androidapp.yemyokyaw.movieapp.data.vo.MovieVO;
import com.androidapp.yemyokyaw.movieapp.delegates.MovieListDelegate;
import com.androidapp.yemyokyaw.movieapp.mvp.views.MovieListView;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by GL-553VD on 1/12/2018.
 */

public class MovieListPresenter extends BasePresenter<MovieListView> implements MovieListDelegate {

    @Inject
    MovieModel mMovieModel;

    public MovieListPresenter(){

    }

    @Override
    public void onCreate(MovieListView view) {
        super.onCreate(view);
        MovieApp movieApp = (MovieApp) mView.getContext();
        movieApp.getMovieAppComponent().inject(this);
    }

    @Override
    public void onStart() {
        List<MovieVO> movieList = mMovieModel.getMovies();
        if (!movieList.isEmpty()) {
            mView.displayMovieList(movieList);
        } else {
            mView.showLoading();
        }
    }

    @Override
    public void onStop() {

    }

    @Override
    public void onTapped(MovieVO movie) {
        mView.navigateToMovieDetails(movie);
    }

    public void onLoadMoreMovie(Context context) {
        mMovieModel.loadMoreMovie(context);
    }

    public void onForceRefreshMovie(Context context) {
        mMovieModel.forceRefreshMovie(context);
    }
}
