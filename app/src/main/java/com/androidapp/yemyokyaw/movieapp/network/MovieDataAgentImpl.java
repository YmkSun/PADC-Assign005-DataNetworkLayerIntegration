package com.androidapp.yemyokyaw.movieapp.network;

import android.content.Context;

import com.androidapp.yemyokyaw.movieapp.events.RestApiEvents;
import com.androidapp.yemyokyaw.movieapp.network.responses.GetMovieResponse;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yemyokyaw on 12/7/17.
 */

public class MovieDataAgentImpl implements MovieDataAgent {

    private static MovieDataAgentImpl objInstance;

    private MovieAPI theAPI;

    private MovieDataAgentImpl() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://padcmyanmar.com/padc-3/popular-movies/apis/")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(okHttpClient)
                .build();

        theAPI = retrofit.create(MovieAPI.class);
    }

    public static MovieDataAgentImpl getInstance() {
        if (objInstance == null) {
            objInstance = new MovieDataAgentImpl();
        }
        return objInstance;
    }

    @Override
    public void loadMovies(String accessToken, int pageNo, final Context context) {
        Call<GetMovieResponse> loadMovieCall = theAPI.loadMovie(pageNo,accessToken);
        loadMovieCall.enqueue(new Callback<GetMovieResponse>() {
            @Override
            public void onResponse(Call<GetMovieResponse> call, Response<GetMovieResponse> response) {
                GetMovieResponse getMovieResponse = response.body();
                if(getMovieResponse != null && getMovieResponse.getMovieList().size()>0) {
                    RestApiEvents.MovieDataLoadedEvent newsDataLoadedEvent = new RestApiEvents.MovieDataLoadedEvent(
                            getMovieResponse.getPageNo(), getMovieResponse.getMovieList(), context);
                    EventBus.getDefault().post(newsDataLoadedEvent);
                } else {
                    RestApiEvents.ErrorInvokingAPIEvent errorEvent
                            = new RestApiEvents.ErrorInvokingAPIEvent("No data could be loaded for now. Pls try again later.");
                    EventBus.getDefault().post(errorEvent);
                }
            }

            @Override
            public void onFailure(Call<GetMovieResponse> call, Throwable t) {
                RestApiEvents.ErrorInvokingAPIEvent errorEvent = new RestApiEvents.ErrorInvokingAPIEvent(t.getMessage());
                EventBus.getDefault().post(errorEvent);
            }
        });

    }
}
