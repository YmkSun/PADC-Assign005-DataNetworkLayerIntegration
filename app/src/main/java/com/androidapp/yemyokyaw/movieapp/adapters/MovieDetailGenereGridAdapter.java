package com.androidapp.yemyokyaw.movieapp.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.androidapp.yemyokyaw.movieapp.R;
import com.androidapp.yemyokyaw.movieapp.data.vo.GenereVO;

import java.util.List;

/**
 * Created by yemyokyaw on 12/19/17.
 */

public class MovieDetailGenereGridAdapter extends BaseAdapter
{

    private Context mContext;
    private List<GenereVO> mGenereList;

    public MovieDetailGenereGridAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=((Activity)mContext).getLayoutInflater();
        View row=inflater.inflate(R.layout.view_genere_btn, null);
        TextView btnGenere=(TextView) row.findViewById(R.id.btn_genere_data);
        return btnGenere;
    }
}
