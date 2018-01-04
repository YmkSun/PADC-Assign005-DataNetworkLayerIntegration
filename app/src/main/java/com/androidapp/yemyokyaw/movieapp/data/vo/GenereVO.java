package com.androidapp.yemyokyaw.movieapp.data.vo;

import android.content.ContentValues;
import android.database.Cursor;

import com.androidapp.yemyokyaw.movieapp.persistence.MovieAppContracts;
import com.google.gson.annotations.SerializedName;

/**
 * Created by yemyokyaw on 12/19/17.
 */

public class GenereVO {

    @SerializedName("genere_id")
    private long genereId;

    @SerializedName("genere_name")
    private String genereName;

    public long getGenereId() {
        return genereId;
    }

    public String getGenereName() {
        return genereName;
    }

    public ContentValues parseToContentValues() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(MovieAppContracts.GenereEntry.COLUMN_GENERE_ID, genereId);
        contentValues.put(MovieAppContracts.GenereEntry.COLUMN_GENERE_NAME, genereName);
        return contentValues;
    }

    public static GenereVO parseFromCursor(Cursor cursor) {
        GenereVO genere = new GenereVO();
        genere.genereId = cursor.getLong(cursor.getColumnIndex(MovieAppContracts.GenereEntry.COLUMN_GENERE_ID));
        genere.genereName = cursor.getString(cursor.getColumnIndex(MovieAppContracts.GenereEntry.COLUMN_GENERE_NAME));
        return genere;
    }
}
