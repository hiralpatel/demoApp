package com.example.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.R;

public class JobDetailsActivity extends AppCompatActivity {

    private LinearLayout linearLayout;
    private ScrollView scrollView;
    private Button btnApply, btnSendOpportunity;
    private TextView tvApplyHere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_detail);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        if (getIntent().hasExtra("jobTitle")) {
            actionBar.setTitle(getIntent().getExtras().getString("jobTitle"));
        }

        scrollView = (ScrollView) findViewById(R.id.scrollView);
        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);

        btnApply = (Button) findViewById(R.id.btnApplyOnline);
        btnSendOpportunity = (Button) findViewById(R.id.btnSendMeOpportunity);
        tvApplyHere = (TextView) findViewById(R.id.tvApplyHere);

        tvApplyHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(JobDetailsActivity.this, JobApplyOnlineActivity.class);
                startActivity(mIntent);
            }
        });

        btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(JobDetailsActivity.this, JobApplyOnlineActivity.class);
                startActivity(mIntent);
            }
        });

        btnSendOpportunity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(JobDetailsActivity.this, JobOpportunityActivity.class);
                startActivity(mIntent);
            }
        });
    }

    /**
     * This is the default method for home back arrow click event
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }
}