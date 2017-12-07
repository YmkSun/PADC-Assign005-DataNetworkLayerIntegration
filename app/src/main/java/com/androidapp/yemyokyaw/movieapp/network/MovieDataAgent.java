package com.androidapp.yemyokyaw.movieapp.network;

/**
 * Created by yemyokyaw on 12/7/17.
 */

public interface MovieDataAgent {

    void loadMovies(String accessToken, int pageNo);

}
