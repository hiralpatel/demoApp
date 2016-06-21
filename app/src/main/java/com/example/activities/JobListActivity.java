package com.example.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.R;
import com.example.adapter.JobsAdapter;
import com.example.client.MyLoopJGet;
import com.example.pojo.Jobs;
import com.example.utils.Common;
import com.example.utils.Utils;
import com.example.views.RecyclerViewScrollListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JobListActivity extends AppCompatActivity {

    private RecyclerView mRecyclerViewJobs;
    private LinearLayoutManager linearLayoutManager;
    private Context context;
    private ArrayList<Jobs> mArrayJobs;
    private TextView llNoValues;
    private JobsAdapter adapter;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_list);
        context = JobListActivity.this;

        mRecyclerViewJobs = (RecyclerView) findViewById(R.id.recycler_view_jobs);
        llNoValues = (TextView) findViewById(R.id.llNoValues);
        mProgressBar = (ProgressBar) findViewById(R.id.mProgressBar);

        linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerViewJobs.setLayoutManager(linearLayoutManager);

        mRecyclerViewJobs.addOnScrollListener(new RecyclerViewScrollListener() {

            @Override
            public void onScrollUp() {

            }

            @Override
            public void onScrollDown() {

            }

            @Override
            public void onLoadMore() {
//                if (Common.isNetworkAvailable(context) && hasNext) {
//                    if (!isLoading) {
//                        isLoading = true;
//                        page++;
//                        adapter.showLoading(true);
//                        getMyVehicles();
//                    }
//                } else {
//                    adapter.showLoading(false);
//                }
            }
        });

//        getJobs();
        mProgressBar.setVisibility(View.GONE);

        mArrayJobs = new ArrayList<>();
        mArrayJobs.add(new Jobs("1", "Front End Designer", "Antwerp", "Jun, 07"));
        mArrayJobs.add(new Jobs("2", "Network Engineer", "Brussels", "Jun, 20"));
        mArrayJobs.add(new Jobs("3", "Digital Transformation Senior Project Lead", "Antwerp", "Jun, 09"));
        mArrayJobs.add(new Jobs("4", "Web Designer", "Brussels", "Jun, 04"));
        mArrayJobs.add(new Jobs("5", "PHP Developer", "Antwerp", "Jun, 09"));

        if (mArrayJobs != null && mArrayJobs.size() > 0) {
            if (adapter == null) {
                adapter = new JobsAdapter(context, mArrayJobs);
                mRecyclerViewJobs.setAdapter(adapter);
            }
            adapter.notifyDataSetChanged();
            llNoValues.setVisibility(View.GONE);
        } else {
            llNoValues.setVisibility(View.VISIBLE);
        }
    }

    /**
     * get jobs from Server
     */
    private void getJobs() {
        MyLoopJGet myLoopJGet = new MyLoopJGet(context, "", onLoopJGetJobsCallComplete, getResources().getString(R.string.url_get_jobs, Utils.getAPIAccessKey(context)));
    }

    /**
     * API parsing of jobs
     */
    MyLoopJGet.OnLoopJGetCallComplete onLoopJGetJobsCallComplete = new MyLoopJGet.OnLoopJGetCallComplete() {
        @Override
        public void response(String result) {
            try {
                JSONObject jobj = new JSONObject(result);
                String response_code = jobj.getString("response_code");
                System.out.println("response onLoopJGetRepBrandAndAddressInfoCallComplete:" + result);
                // TODO uncomment this code block
                mProgressBar.setVisibility(View.GONE);
//                if (response_code.equals(getResources().getString(R.string.success_code))) {
//                } else {
//                    Common.showAlertDialog(context, "", jobj.getJSONArray("error").get(0).toString(), true, coordinatorLayout);
//                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    };
}