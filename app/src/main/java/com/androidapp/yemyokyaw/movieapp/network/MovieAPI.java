package com.androidapp.yemyokyaw.movieapp.network;

import com.androidapp.yemyokyaw.movieapp.network.responses.GetMovieResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by yemyokyaw on 12/7/17.
 */

public interface MovieAPI {

    @FormUrlEncoded
    @POST("v1/getPopularMovies.php")
    Call<GetMovieResponse> loadMovie(
            @Field("page") int pageIndex,
            @Field("access_token") String accessToken);

}
