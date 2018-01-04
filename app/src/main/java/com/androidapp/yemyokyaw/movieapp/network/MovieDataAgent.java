package com.androidapp.yemyokyaw.movieapp.network;

import android.content.Context;

/**
 * Created by yemyokyaw on 12/7/17.
 */

public interface MovieDataAgent {

    void loadMovies(String accessToken, int pageNo, Context context);

}
