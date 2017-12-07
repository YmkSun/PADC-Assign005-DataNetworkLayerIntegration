package com.androidapp.yemyokyaw.movieapp.network.responses;

import com.androidapp.yemyokyaw.movieapp.data.vo.MovieVO;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yemyokyaw on 12/7/17.
 */

public class GetMovieResponse {

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("apiVersion")
    private String apiVersion;

    @SerializedName("page")
    private int pageNo;

    @SerializedName("popular-movies")
    private List<MovieVO> movieList;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public int getPageNo() {
        return pageNo;
    }

    public List<MovieVO> getMovieList() {
        if (movieList == null) {
            movieList = new ArrayList<>();
        }
        return movieList;
    }

}
