package com.androidapp.yemyokyaw.movieapp.data.vo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Movie;

import com.androidapp.yemyokyaw.movieapp.persistence.MovieAppContracts;
import com.google.gson.annotations.SerializedName;

/**
 * Created by yemyokyaw on 12/6/17.
 */

public class MovieVO {

    @SerializedName("id")
    private long id;

    @SerializedName("vote_count")
    private int vote_count;

    @SerializedName("video")
    private boolean video;

    @SerializedName("vote_average")
    private float vote_average;

    @SerializedName("title")
    private String title;

    @SerializedName("popularity")
    private float popularity;

    @SerializedName("poster_path")
    private String poster_path;

    @SerializedName("original_language")
    private String original_language;

    @SerializedName("genre_ids")
    private int[] genre_ids;

    @SerializedName("backdrop_path")
    private String backdrop_path;

    @SerializedName("adult")
    private boolean adult;

    @SerializedName("overview")
    private String overview;

    @SerializedName("release_date")
    private String release_date;

    public long getId() {
        return id;
    }

    public int getVote_count() {
        return vote_count;
    }

    public boolean isVideo() {
        return video;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public boolean isAdult() {
        return adult;
    }

    public String getOverview() {
        return overview;
    }

    public float getVote_average() {
        return vote_average;
    }

    public String getTitle() {
        return title;
    }

    public float getPopularity() {
        return popularity;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public String getRelease_date() {
        return release_date;
    }

    public int[] getGenre_ids() { return  genre_ids; }

    public ContentValues parseToContentValues() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(MovieAppContracts.MovieEntry.COLUMN_MOVIE_ID, id);
        contentValues.put(MovieAppContracts.MovieEntry.COLUMN_VOTE_COUNT, vote_count);
        contentValues.put(MovieAppContracts.MovieEntry.COLUMN_VIDEO, video);
        contentValues.put(MovieAppContracts.MovieEntry.COLUMN_VOTE_AVERAGE, vote_average);
        contentValues.put(MovieAppContracts.MovieEntry.COLUMN_TITLE, title);
        contentValues.put(MovieAppContracts.MovieEntry.COLUMN_POPULARITY, popularity);
        contentValues.put(MovieAppContracts.MovieEntry.COLUMN_POSTER_PATH, poster_path);
        contentValues.put(MovieAppContracts.MovieEntry.COLUMN_ORIGINAL_LANGUAGE, original_language);
        contentValues.put(MovieAppContracts.MovieEntry.COLUMN_BACKDROP_PATH, backdrop_path);
        contentValues.put(MovieAppContracts.MovieEntry.COLUMN_ADULT, adult);
        contentValues.put(MovieAppContracts.MovieEntry.COLUMN_OVERVIEW, overview);
        contentValues.put(MovieAppContracts.MovieEntry.COLUMN_RELEASE_DATE, release_date);
        return contentValues;
    }

    public static MovieVO parseFromCursor(Context context, Cursor cursor) {
        MovieVO movie = new MovieVO();
        movie.id = cursor.getLong(cursor.getColumnIndex(MovieAppContracts.MovieEntry.COLUMN_MOVIE_ID));
        movie.vote_count = cursor.getInt(cursor.getColumnIndex(MovieAppContracts.MovieEntry.COLUMN_VOTE_COUNT));
        movie.video = cursor.getInt(cursor.getColumnIndex(MovieAppContracts.MovieEntry.COLUMN_VIDEO))==1?true:(cursor.getInt(cursor.getColumnIndex(MovieAppContracts.MovieEntry.COLUMN_VIDEO))==0?false:null);
        movie.vote_average = cursor.getFloat(cursor.getColumnIndex(MovieAppContracts.MovieEntry.COLUMN_VOTE_AVERAGE));
        movie.title = cursor.getString(cursor.getColumnIndex(MovieAppContracts.MovieEntry.COLUMN_TITLE));
        movie.popularity = cursor.getFloat(cursor.getColumnIndex(MovieAppContracts.MovieEntry.COLUMN_POPULARITY));
        movie.poster_path = cursor.getString(cursor.getColumnIndex(MovieAppContracts.MovieEntry.COLUMN_POSTER_PATH));
        movie.original_language = cursor.getString(cursor.getColumnIndex(MovieAppContracts.MovieEntry.COLUMN_ORIGINAL_LANGUAGE));
        movie.backdrop_path = cursor.getString(cursor.getColumnIndex(MovieAppContracts.MovieEntry.COLUMN_BACKDROP_PATH));
        movie.adult = cursor.getInt(cursor.getColumnIndex(MovieAppContracts.MovieEntry.COLUMN_ADULT))==1?true:(cursor.getInt(cursor.getColumnIndex(MovieAppContracts.MovieEntry.COLUMN_ADULT))==0?false:null);
        movie.overview = cursor.getString(cursor.getColumnIndex(MovieAppContracts.MovieEntry.COLUMN_OVERVIEW));
        movie.release_date = cursor.getString(cursor.getColumnIndex(MovieAppContracts.MovieEntry.COLUMN_RELEASE_DATE));
        return movie;
    }


}
