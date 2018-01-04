package com.androidapp.yemyokyaw.movieapp.data.model;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import com.androidapp.yemyokyaw.movieapp.MovieApp;
import com.androidapp.yemyokyaw.movieapp.data.vo.MovieVO;
import com.androidapp.yemyokyaw.movieapp.events.RestApiEvents;
import com.androidapp.yemyokyaw.movieapp.network.MovieDataAgentImpl;
import com.androidapp.yemyokyaw.movieapp.persistence.MovieAppContracts;
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

    public List<MovieVO> getMovies() {
        return mMovie;
    }

    public void startLoadingMovie(Context context) {
        MovieDataAgentImpl.getInstance().loadMovies(AppConstants.ACCESS_TOKEN, moviePageIndex, context);
    }

    public void loadMoreMovie(Context context) {
        MovieDataAgentImpl.getInstance().loadMovies(AppConstants.ACCESS_TOKEN, moviePageIndex, context);
    }

    @Subscribe
    public void onMovieDataLoaded(RestApiEvents.MovieDataLoadedEvent event) {
        mMovie.addAll(event.getLoadMovies());
        moviePageIndex = event.getLoadedPageIndex() + 1;

        ContentValues[] movieCVs = new ContentValues[event.getLoadMovies().size()];
        for(int index = 0; index < movieCVs.length; index++) {
            movieCVs[index] = event.getLoadMovies().get(index).parseToContentValues();
        }
        int insertedRow = event.getContext().getContentResolver().bulkInsert(MovieAppContracts.MovieEntry.CONTENT_URI, movieCVs);
        Log.d(MovieApp.LOG_TAG, "Inserted Row:"+insertedRow);
    }

    public void forceRefreshMovie(Context context) {
        mMovie = new ArrayList<>();
        moviePageIndex = 1;
        startLoadingMovie(context);
    }

}
