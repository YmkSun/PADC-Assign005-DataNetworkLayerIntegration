package com.androidapp.yemyokyaw.movieapp.dagger;

import android.content.Context;

import com.androidapp.yemyokyaw.movieapp.utils.ConfigUtils;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by GL-553VD on 1/12/2018.
 */
@Module
public class UtilsModule {

    @Provides
    @Singleton
    public ConfigUtils provideConfigUtils(Context context) {
        return new ConfigUtils(context);
    }
}
