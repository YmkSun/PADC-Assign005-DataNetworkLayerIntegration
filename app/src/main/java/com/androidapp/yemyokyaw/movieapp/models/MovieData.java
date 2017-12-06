package com.androidapp.yemyokyaw.movieapp.models;

/**
 * Created by yemyokyaw on 12/5/17.
 */

public class MovieData {

    private String title;
    private String type;
    private String imgUrl;
    private float rating;
    private float popularity;
    private int imgId;

    public MovieData(){
        super();
        this.title = "";
        this.type = "";
        this.imgUrl = "";
        this.rating = 0.0f;
        this.popularity = 0.0f;
        this.imgId = 0;
    }

    public MovieData(String title, String type, String imgUrl, float rating, float popularity, int imgId) {
        this.title = title;
        this.type = type;
        this.imgUrl = imgUrl;
        this.rating = rating;
        this.popularity = popularity;
        this.imgId = imgId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public float getPopularity() {
        return popularity;
    }

    public void setPopularity(float popularity) {
        this.popularity = popularity;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }
}
