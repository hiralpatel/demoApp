package com.example.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.example.R;


/**
 * used for holding row
 */
public class LoaderViewHolder extends RecyclerView.ViewHolder {


    ProgressBar mProgressBar;

    public LoaderViewHolder(View itemView) {
        super(itemView);
        mProgressBar = (ProgressBar) itemView.findViewById(R.id.row_load_more_progressBar);
    }
}
