package com.androidapp.yemyokyaw.movieapp.models;

import com.androidapp.yemyokyaw.movieapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yemyokyaw on 12/6/17.
 */

public class MovieListData {

    private List<MovieData> list = new ArrayList<>();

    public MovieListData() {
        MovieData data = new MovieData("COCO","(Music, Animation)","",8.5f,5.0f, R.drawable.coco);
        list.add(data);
        data = new MovieData("Justic League","(Action)","",8.0f,4.5f,R.drawable.justiceleague);
        list.add(data);
        data = new MovieData("Stranger Things","(Adventure, Action)","",9.0f,4.0f,R.drawable.strangerthings);
        list.add(data);
    }

    public List<MovieData> getList() {
        return list;
    }
}
