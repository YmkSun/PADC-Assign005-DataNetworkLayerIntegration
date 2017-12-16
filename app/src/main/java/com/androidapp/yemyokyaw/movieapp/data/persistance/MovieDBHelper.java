package com.androidapp.yemyokyaw.movieapp.data.persistance;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.androidapp.yemyokyaw.movieapp.data.persistance.MovieAppContracts.MovieEntry;

/**
 * Created by yemyokyaw on 12/16/17.
 */

public class MovieDBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "movie_data.db";
    private static final int DB_VERSION = 1;
    private static final String SQL_CREATE_MOVIE_DATA_TABLE = "";

    public MovieDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_MOVIE_DATA_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + MovieEntry.TABLE_NAME);
        onCreate(db);
    }
}
