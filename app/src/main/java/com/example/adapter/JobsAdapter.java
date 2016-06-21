package com.example.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.R;
import com.example.activities.JobDetailsActivity;
import com.example.pojo.Jobs;

import java.util.ArrayList;


/**
 * Created by Hiral on 21-June-16.
 */
public class JobsAdapter extends RecyclerView.Adapter<JobsAdapter.ViewHolder> {
    Context context;
    private ArrayList<Jobs> rowItems;
    LayoutInflater mInflater;

    public JobsAdapter(Context context, ArrayList<Jobs> items) {
        mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        this.context = context;
        this.rowItems = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_job_list, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.tvJobTitle.setText(rowItems.get(position).getJobTitle());
        holder.tvJobLocation.setText(rowItems.get(position).getJobLocation());
        holder.TvJobDate.setText(rowItems.get(position).getJobDate());

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(context, JobDetailsActivity.class);
                mIntent.putExtra("jobId", rowItems.get(position).getJobId());
                mIntent.putExtra("jobTitle", rowItems.get(position).getJobTitle());
                context.startActivity(mIntent);
            }
        });

        holder.itemView.setTag(rowItems.get(position));
    }

    @Override
    public int getItemCount() {
        return rowItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvJobTitle, tvJobLocation, TvJobDate;
        RelativeLayout relativeLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            tvJobTitle = (TextView) itemView.findViewById(R.id.tvJobTitle);
            tvJobLocation = (TextView) itemView.findViewById(R.id.tvJobLocation);
            TvJobDate = (TextView) itemView.findViewById(R.id.tvJobDate);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.relativeLayout);
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
