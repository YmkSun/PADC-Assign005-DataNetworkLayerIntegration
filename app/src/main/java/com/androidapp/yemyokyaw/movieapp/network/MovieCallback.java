package com.androidapp.yemyokyaw.movieapp.network;

import com.androidapp.yemyokyaw.movieapp.events.RestApiEvents;

import org.greenrobot.eventbus.EventBus;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by yemyokyaw on 1/5/18.
 */

public abstract class MovieCallback<T extends MovieResponse> implements Callback<T> {

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        MovieResponse sfcResponse = response.body();
        if (sfcResponse == null) {
            RestApiEvents.ErrorInvokingAPIEvent errorEvent
                    = new RestApiEvents.ErrorInvokingAPIEvent("No data could be loaded for now. Pls try again later.");
            EventBus.getDefault().post(errorEvent);
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        RestApiEvents.ErrorInvokingAPIEvent errorEvent = new RestApiEvents.ErrorInvokingAPIEvent(t.getMessage());
        EventBus.getDefault().post(errorEvent);
    }
}
