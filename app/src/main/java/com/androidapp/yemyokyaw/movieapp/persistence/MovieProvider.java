package com.androidapp.yemyokyaw.movieapp.persistence;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by yemyokyaw on 1/4/18.
 */

public class MovieProvider extends ContentProvider {

    public static final int MOVIE = 100;
    public static final int GENERE = 200;
    public static final int MOVIE_GENERE = 300;

    public static final UriMatcher sUriMatcher = buildUriMatcher();

    public static MovieDBHelper mDBHelper;

    public static UriMatcher buildUriMatcher() {
        UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(MovieAppContracts.CONTENT_AUTHORITY,MovieAppContracts.PATH_MOVIE,MOVIE);
        uriMatcher.addURI(MovieAppContracts.CONTENT_AUTHORITY,MovieAppContracts.PATH_GENERE,GENERE);
        uriMatcher.addURI(MovieAppContracts.CONTENT_AUTHORITY,MovieAppContracts.PATH_MOVIE_GENERE,MOVIE_GENERE);
        return uriMatcher;
    }

    public String getTableName(Uri uri) {
        switch (sUriMatcher.match(uri)) {
            case MOVIE: return MovieAppContracts.MovieEntry.TABLE_NAME;
            case GENERE: return MovieAppContracts.GenereEntry.TABLE_NAME;
            case MOVIE_GENERE: return MovieAppContracts.MovieGenereEntry.TABLE_NAME;
        }
        return null;
    }

    public Uri getContentUri(Uri uri) {
        switch (sUriMatcher.match(uri)) {
            case MOVIE: return MovieAppContracts.MovieEntry.CONTENT_URI;
            case GENERE: return MovieAppContracts.GenereEntry.CONTENT_URI;
            case MOVIE_GENERE: return MovieAppContracts.MovieGenereEntry.CONTENT_URI;
        }
        return null;
    }

    @Override
    public boolean onCreate() {
        mDBHelper = new MovieDBHelper(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        Cursor queryCursor = mDBHelper.getReadableDatabase().query(getTableName(uri),
                projection,
                selection,
                selectionArgs,
                null,
                null,
                sortOrder);

        if (getContext() != null) {
            queryCursor.setNotificationUri(getContext().getContentResolver(), uri);
        }

        return queryCursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        switch (sUriMatcher.match(uri)) {
            case MOVIE: return MovieAppContracts.MovieEntry.DIR_TYPE;
            case GENERE: return MovieAppContracts.GenereEntry.DIR_TYPE;
            case MOVIE_GENERE: return MovieAppContracts.MovieGenereEntry.DIR_TYPE;
        }
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        SQLiteDatabase db = mDBHelper.getWritableDatabase();
        String tableName = getTableName(uri);
        long _id = db.insert(tableName, null, values);
        if (_id > 0) {
            Uri tableContentUri = getContentUri(uri);
            Uri insertedUri = ContentUris.withAppendedId(tableContentUri, _id);

            if (getContext() != null) {
                getContext().getContentResolver().notifyChange(uri, null);
            }

            return insertedUri;
        }
        return null;
    }

    @Override
    public int bulkInsert(@NonNull Uri uri, @NonNull ContentValues[] values) {
        final SQLiteDatabase db = mDBHelper.getWritableDatabase();
        String tableName = getTableName(uri);
        int insertedCount = 0;

        try {
            db.beginTransaction();
            for (ContentValues cv : values) {
                long _id = db.insert(tableName, null, cv);
                if (_id > 0) {
                    insertedCount++;
                }
            }
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
            db.close();
        }

        Context context = getContext();
        if (context != null) {
            context.getContentResolver().notifyChange(uri, null);
        }

        return insertedCount;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        SQLiteDatabase db = mDBHelper.getWritableDatabase();
        int deletedRow;
        String tableName = getTableName(uri);

        deletedRow = db.delete(tableName, selection, selectionArgs);
        Context context = getContext();
        if (context != null && deletedRow > 0) {
            context.getContentResolver().notifyChange(uri, null);
        }
        return deletedRow;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String selection, @Nullable String[] selectionArgs) {
        SQLiteDatabase db = mDBHelper.getWritableDatabase();
        int updatedRow;
        String tableName = getTableName(uri);

        updatedRow = db.update(tableName, contentValues, selection, selectionArgs);
        Context context = getContext();
        if (context != null && updatedRow > 0) {
            context.getContentResolver().notifyChange(uri, null);
        }
        return updatedRow;
    }
}
