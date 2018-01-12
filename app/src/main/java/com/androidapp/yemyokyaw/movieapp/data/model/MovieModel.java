package com.androidapp.yemyokyaw.movieapp.data.model;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import com.androidapp.yemyokyaw.movieapp.MovieApp;
import com.androidapp.yemyokyaw.movieapp.data.vo.MovieVO;
import com.androidapp.yemyokyaw.movieapp.events.RestApiEvents;
import com.androidapp.yemyokyaw.movieapp.network.MovieDataAgent;
import com.androidapp.yemyokyaw.movieapp.persistence.MovieAppContracts;
import com.androidapp.yemyokyaw.movieapp.utils.AppConstants;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by yemyokyaw on 12/6/17.
 */

public class MovieModel {

    private static MovieModel objInstance;

    private List<MovieVO> mMovie;
    private int moviePageIndex = 1;

    @Inject
    MovieDataAgent mMovieDataAgent;

    public MovieModel(Context context) {
        EventBus.getDefault().register(this);
        mMovie = new ArrayList<>();
        MovieApp movieApp = (MovieApp) context.getApplicationContext();
        movieApp.getMovieAppComponent().inject(this);
    }

    public List<MovieVO> getMovies() {
        return mMovie;
    }

    public void startLoadingMovie(Context context) {
        mMovieDataAgent.loadMovies(AppConstants.ACCESS_TOKEN, moviePageIndex, context);
    }

    public void loadMoreMovie(Context context) {
        mMovieDataAgent.loadMovies(AppConstants.ACCESS_TOKEN, moviePageIndex, context);
    }

    @Subscribe
    public void onMovieDataLoaded(RestApiEvents.MovieDataLoadedEvent event) {
        mMovie.addAll(event.getLoadMovies());
        moviePageIndex = event.getLoadedPageIndex() + 1;

        ContentValues[] movieCVs = new ContentValues[event.getLoadMovies().size()];
        List<ContentValues> genereCVList = new ArrayList<>();
        List<ContentValues> movieGenereCVList = new ArrayList<>();
        for(int index = 0; index < movieCVs.length; index++) {

            MovieVO movie = event.getLoadMovies().get(index);
            movieCVs[index] = movie.parseToContentValues();

            for (int genereId : movie.getGenre_ids()) {

                ContentValues genereCV = new ContentValues();
                genereCV.put(MovieAppContracts.GenereEntry.COLUMN_GENERE_ID, genereId);
                genereCV.put(MovieAppContracts.GenereEntry.COLUMN_GENERE_NAME, "");
                genereCVList.add(genereCV);


                ContentValues movieGenereCV = new ContentValues();
                movieGenereCV.put(MovieAppContracts.MovieGenereEntry.COLUMN_GENERE_ID, genereId);
                movieGenereCV.put(MovieAppContracts.MovieGenereEntry.COLUMN_MOVIE_ID, movie.getId());
                movieGenereCVList.add(movieGenereCV);
            }
        }
        int insertedGeneres = event.getContext().getContentResolver().bulkInsert(MovieAppContracts.GenereEntry.CONTENT_URI, genereCVList.toArray(new ContentValues[0]));
        Log.d(MovieApp.LOG_TAG, "insertedGeneres : " + insertedGeneres);

        int insertedMovies = event.getContext().getContentResolver().bulkInsert(MovieAppContracts.MovieEntry.CONTENT_URI, movieCVs);
        Log.d(MovieApp.LOG_TAG, "Inserted Row:"+insertedMovies);

        int insertedMovieGeneres = event.getContext().getContentResolver().bulkInsert(MovieAppContracts.MovieGenereEntry.CONTENT_URI, movieGenereCVList.toArray(new ContentValues[0]));
        Log.d(MovieApp.LOG_TAG, "insertedImagesInNews : " + insertedMovieGeneres);
    }

    public void forceRefreshMovie(Context context) {
        mMovie = new ArrayList<>();
        moviePageIndex = 1;
        startLoadingMovie(context);
    }

}
