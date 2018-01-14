package com.androidapp.yemyokyaw.movieapp.activities;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.androidapp.yemyokyaw.movieapp.R;
import com.androidapp.yemyokyaw.movieapp.adapters.MovieDetailGenereGridAdapter;
import com.androidapp.yemyokyaw.movieapp.adapters.MovieListRvAdapter;
import com.androidapp.yemyokyaw.movieapp.adapters.MovieTrailerAdapter;
import com.androidapp.yemyokyaw.movieapp.data.vo.MovieVO;
import com.androidapp.yemyokyaw.movieapp.delegates.MovieListDelegate;
import com.androidapp.yemyokyaw.movieapp.persistence.MovieAppContracts;
import com.androidapp.yemyokyaw.movieapp.utils.AppConstants;
import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieDetailActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor>, MovieListDelegate {

    public static final String IE_MOVIE_ID = "IE_MOVIE_ID";
    public static final int MOVIE_DETAIL_LOADER_ID = 1002;

    public String mMoiveId;

    @BindView(R.id.rv_movie_trailer_images)
    public RecyclerView rvMovieTrailerImages;

    @BindView(R.id.gv_genere_list)
    public GridView gvGenereList;

    @BindView(R.id.iv_movie_detial_head_bg)
    ImageView ivMovieDetailBackdrop;

    @BindView(R.id.iv_movie_detail_img_id)
    ImageView ivMovieDetailPoster;

    @BindView(R.id.tv_movie_rating_id)
    TextView tvMovieRating;

    @BindView(R.id.tv_movie_title)
    TextView tvMovieTitle;

    @BindView(R.id.tv_movie_detail_overview)
    TextView tvMovieDetailOverview;

    @BindView(R.id.rb_movie_detail_popular_id)
    RatingBar rbMoviePopular;

    MovieTrailerAdapter mMovieListRvAdapter;

    public static Intent newIntent(Context context, String movieId) {
        Intent intent = new Intent(context, MovieDetailActivity.class);
        intent.putExtra(IE_MOVIE_ID, movieId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        ButterKnife.bind(this,this);

        mMoiveId = getIntent().getStringExtra(IE_MOVIE_ID);
        if (TextUtils.isEmpty(mMoiveId)) {
            throw new UnsupportedOperationException("Id required for MovieDetailActivity");
        } else {
            getSupportLoaderManager().initLoader(MOVIE_DETAIL_LOADER_ID, null, this);
        }


        mMovieListRvAdapter = new MovieTrailerAdapter(getApplicationContext(),this);
        rvMovieTrailerImages.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        rvMovieTrailerImages.setAdapter(mMovieListRvAdapter);

        MovieDetailGenereGridAdapter movieDetailGenereGridAdapter = new MovieDetailGenereGridAdapter(this);
        gvGenereList.setAdapter(movieDetailGenereGridAdapter);
    }

    @Override
    public void onTapped(MovieVO movie) {
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(getApplicationContext(),
                MovieAppContracts.MovieEntry.CONTENT_URI,
                null,
                MovieAppContracts.MovieEntry.COLUMN_MOVIE_ID + " = ?", new String[]{mMoiveId},
                null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        if(data != null && data.moveToFirst()) {
            MovieVO movie = MovieVO.parseFromCursor(getApplicationContext(), data);
            bindData(movie);
        }
    }

    public void bindData(MovieVO movie) {
        String imgBackDropUrl = AppConstants.IMAGE_URL + movie.getBackdrop_path();
        String imgPosterUrl = AppConstants.IMAGE_URL + movie.getPoster_path();
        tvMovieRating.setText(String.valueOf(movie.getVote_average()));
        tvMovieTitle.setText(movie.getTitle());
        tvMovieDetailOverview.setText(movie.getOverview());
        rbMoviePopular.setRating(movie.getPopularity()/250.f);

        Glide.with(ivMovieDetailBackdrop.getContext())
                .load(imgBackDropUrl)
                .centerCrop()
                .placeholder(R.drawable.movie_photo_placeholder)
                .error(R.drawable.movie_photo_placeholder)
                .into(ivMovieDetailBackdrop);

        Glide.with(ivMovieDetailPoster.getContext())
                .load(imgPosterUrl)
                .centerCrop()
                .placeholder(R.drawable.movie_photo_placeholder)
                .error(R.drawable.movie_photo_placeholder)
                .into(ivMovieDetailPoster);

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}
