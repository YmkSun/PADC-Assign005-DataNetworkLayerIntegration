package com.androidapp.yemyokyaw.movieapp.viewholders;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.androidapp.yemyokyaw.movieapp.MovieApp;
import com.androidapp.yemyokyaw.movieapp.R;
import com.androidapp.yemyokyaw.movieapp.data.vo.MovieVO;
import com.androidapp.yemyokyaw.movieapp.delegates.MovieListDelegate;
import com.androidapp.yemyokyaw.movieapp.utils.AppConstants;
import com.bumptech.glide.Glide;

/**
 * Created by yemyokyaw on 12/5/17.
 */

public class MovieListViewHolder extends BaseViewHolder<MovieVO> {

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

    @Override
    public void setData(MovieVO data) {
        tvMovieTitle.setText(data.getTitle());
        Log.i(MovieApp.LOG_TAG,data.getTitle());
        tvMovieType.setText(data.getRelease_date());
        tvMovieRating.setText(String.valueOf(data.getVote_average()));
        rbMoviePopular.setRating((data.getPopularity()/250.0f)*5.0f);

        String imgUrl = AppConstants.IMAGE_URL+data.getPoster_path();
        Log.i("INFO",imgUrl);
        Glide.with(ivMovieImg.getContext())
                .load(imgUrl)
                .centerCrop()
                .placeholder(R.drawable.movie_photo_placeholder)
                .error(R.drawable.movie_photo_placeholder)
                .into(ivMovieImg);

    }

    @Override
    public void onClick(View v) {

    }
}
