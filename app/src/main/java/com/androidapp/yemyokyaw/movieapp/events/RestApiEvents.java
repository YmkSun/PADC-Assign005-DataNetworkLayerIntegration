package com.androidapp.yemyokyaw.movieapp.events;

import android.content.ContentProvider;
import android.content.Context;

import com.androidapp.yemyokyaw.movieapp.data.vo.MovieVO;

import java.util.List;

/**
 * Created by yemyokyaw on 12/7/17.
 */

public class RestApiEvents {

    public static class EmptyResponseEvent {

    }

    public static class ErrorInvokingAPIEvent {
        private String errorMsg;

        public ErrorInvokingAPIEvent(String errorMsg) {
            this.errorMsg = errorMsg;
        }

        public String getErrorMsg() {
            return errorMsg;
        }
    }

    public static class MovieDataLoadedEvent {
        private int loadedPageIndex;
        private List<MovieVO> loadMovies;
        private Context context;

        public MovieDataLoadedEvent(int loadedPageIndex, List<MovieVO> loadMovies, Context context) {
            this.loadedPageIndex = loadedPageIndex;
            this.loadMovies = loadMovies;
            this.context = context;
        }

        public int getLoadedPageIndex() {
            return loadedPageIndex;
        }

        public List<MovieVO> getLoadMovies() {
            return loadMovies;
        }

        public Context getContext() {
            return context;
        }
    }
}
