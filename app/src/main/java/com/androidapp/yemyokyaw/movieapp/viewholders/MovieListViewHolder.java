package com.androidapp.yemyokyaw.movieapp.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.androidapp.yemyokyaw.movieapp.R;
import com.androidapp.yemyokyaw.movieapp.delegates.MovieListDelegate;
import com.androidapp.yemyokyaw.movieapp.models.MovieData;

/**
 * Created by yemyokyaw on 12/5/17.
 */

public class MovieListViewHolder extends RecyclerView.ViewHolder {

    ImageView ivMovieImg;
    TextView tvMovieTitle;
    TextView tvMovieType;
    TextView tvMovieRating;
    RatingBar rbMoviePopular;

    public MovieListViewHolder(View view, MovieListDelegate mlDelegate) {
        super(view);
        tvMovieType = (TextView) view.findViewById(R.id.tv_moive_type_id);
        tvMovieTitle = (TextView) view.findViewById(R.id.tv_movie_title_id);
        tvMovieRating = (TextView) view.findViewById(R.id.tv_movie_rating_id);
        rbMoviePopular = (RatingBar) view.findViewById(R.id.rb_movie_popular_id);
        ivMovieImg = (ImageView) view.findViewById(R.id.cv_movie_img_id);
    }

    public void bindData(MovieData movieData) {
        tvMovieTitle.setText(movieData.getTitle());
        tvMovieType.setText(movieData.getType());
        tvMovieRating.setText(String.valueOf(movieData.getRating()));
        rbMoviePopular.setRating(movieData.getPopularity());
        ivMovieImg.setImageResource(movieData.getImgId());
    }

}
