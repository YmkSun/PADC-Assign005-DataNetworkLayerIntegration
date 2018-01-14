package com.androidapp.yemyokyaw.movieapp.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.androidapp.yemyokyaw.movieapp.persistence.MovieAppContracts.MovieEntry;
import com.androidapp.yemyokyaw.movieapp.persistence.MovieAppContracts.GenereEntry;
import com.androidapp.yemyokyaw.movieapp.persistence.MovieAppContracts.MovieGenereEntry;

/**
 * Created by yemyokyaw on 12/16/17.
 */

public class MovieDBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "movie_data.db";
    private static final int DB_VERSION = 1;
    private static final String SQL_CREATE_MOVIE_DATA_TABLE = "CREATE TABLE " + MovieEntry.TABLE_NAME + " (" +
            MovieEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            MovieEntry.COLUMN_MOVIE_ID + " INTEGER, " +
            MovieEntry.COLUMN_TITLE + "  VARCHAR(256), " +
            MovieEntry.COLUMN_BACKDROP_PATH + " TEXT, " +
            MovieEntry.COLUMN_POSTER_PATH + " TEXT, " +
            MovieEntry.COLUMN_RELEASE_DATE + " TEXT, " +
            MovieEntry.COLUMN_ORIGINAL_LANGUAGE + " TEXT, " +
            MovieEntry.COLUMN_OVERVIEW + " TEXT, " +
            MovieEntry.COLUMN_POPULARITY + " REAL, " +
            MovieEntry.COLUMN_VIDEO + " NUMERIC, " +
            MovieEntry.COLUMN_ADULT + " NUMERIC, " +
            MovieEntry.COLUMN_ORIGINAL_TITLE + " TEXT, " +
            MovieEntry.COLUMN_VOTE_AVERAGE + " REAL, " +
            MovieEntry.COLUMN_VOTE_COUNT + " INTEGER, " +
            " UNIQUE (" + MovieEntry.COLUMN_TITLE + ") ON CONFLICT REPLACE" +
            ");";

    private static final String SQL_CREATE_GENERE_DATA_TABLE = "CREATE TABLE " + GenereEntry.TABLE_NAME + " (" +
            GenereEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            GenereEntry.COLUMN_GENERE_ID + " INTEGER, " +
            GenereEntry.COLUMN_GENERE_NAME + "  VARCHAR(256), " +
            " UNIQUE (" + GenereEntry.COLUMN_GENERE_NAME + ") ON CONFLICT REPLACE" +
            ");";

    private static final String SQL_CREATE_MOVIE_GENERE_TABLE = "CREATE TABLE " + MovieGenereEntry.TABLE_NAME + " (" +
            MovieGenereEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            MovieGenereEntry.COLUMN_MOVIE_ID + " INTEGER, " +
            MovieGenereEntry.COLUMN_GENERE_ID + " INTEGER" +
            ");";

    public MovieDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_MOVIE_GENERE_TABLE);
        db.execSQL(SQL_CREATE_GENERE_DATA_TABLE);
        db.execSQL(SQL_CREATE_MOVIE_DATA_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + MovieEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + GenereEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + MovieGenereEntry.TABLE_NAME);
        onCreate(db);
    }
}
