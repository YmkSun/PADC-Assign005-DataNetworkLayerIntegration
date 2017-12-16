package com.androidapp.yemyokyaw.movieapp.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.androidapp.yemyokyaw.movieapp.R;
import com.androidapp.yemyokyaw.movieapp.data.vo.MovieVO;
import com.androidapp.yemyokyaw.movieapp.delegates.MovieListDelegate;

/**
 * Created by yemyokyaw on 12/16/17.
 */

public class MovieTrailerViewHolder extends RecyclerView.ViewHolder {

    private MovieListDelegate mDelegate;

    public MovieTrailerViewHolder(View itemView, MovieListDelegate newsItemDelegate) {
        super(itemView);
        mDelegate = newsItemDelegate;
    }
}
