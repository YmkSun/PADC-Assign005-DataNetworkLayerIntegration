package com.androidapp.yemyokyaw.movieapp.mvp.views;

import android.content.Context;

import com.androidapp.yemyokyaw.movieapp.data.vo.MovieVO;

import java.util.List;

/**
 * Created by GL-553VD on 1/12/2018.
 */

public interface MovieListView {

    Context getContext();

    void displayMovieList(List<MovieVO> movieList);

    void showLoading();

    void navigateToMovieDetails(MovieVO movie);
}
