package com.androidapp.yemyokyaw.movieapp.data.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by yemyokyaw on 12/19/17.
 */

public class GenereVO {

    @SerializedName("genere_id")
    private long genereId;

    @SerializedName("movie_id")
    private long movieId;

    public long getGenereId() {
        return genereId;
    }

    public long getMovieId() {
        return movieId;
    }
}
