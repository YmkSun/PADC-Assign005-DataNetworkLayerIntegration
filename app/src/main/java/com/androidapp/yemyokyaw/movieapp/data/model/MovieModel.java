package com.androidapp.yemyokyaw.movieapp.data.model;

import com.androidapp.yemyokyaw.movieapp.data.vo.MovieVO;
import com.androidapp.yemyokyaw.movieapp.events.RestApiEvents;
import com.androidapp.yemyokyaw.movieapp.network.MovieDataAgentImpl;
import com.androidapp.yemyokyaw.movieapp.utils.AppConstants;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yemyokyaw on 12/6/17.
 */

public class MovieModel {

    private static MovieModel objInstance;

    private List<MovieVO> mMovie;
    private int moviePageIndex = 1;

    private MovieModel() {
        EventBus.getDefault().register(this);
        mMovie = new ArrayList<>();
    }

    public static MovieModel getInstance() {
        if(objInstance == null) {
            objInstance = new MovieModel();
        }
        return objInstance;
    }

    public void startLoadingMovie() {
        MovieDataAgentImpl.getInstance().loadMovies(AppConstants.ACCESS_TOKEN, moviePageIndex);
    }

    @Subscribe
    public void onMovieDataLoaded(RestApiEvents.MovieDataLoadedEvent event) {
        mMovie.addAll(event.getLoadMovies());
        moviePageIndex = event.getLoadedPageIndex() + 1;
    }

}
