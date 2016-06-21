package com.example.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.R;
import com.example.client.MyLoopJGet;
import com.example.utils.Common;

import org.json.JSONException;
import org.json.JSONObject;

public class SplashActivity extends Activity {

    private SplashActivity context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        context = SplashActivity.this;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mIntent = new Intent(SplashActivity.this, JobListActivity.class);
                mIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                mIntent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(mIntent);
                finish();
            }
        }, 2500);
    }


    /**
     * Get access key api call
     */
    private void getAccessKey() {
        // TODO uncomment this line
        MyLoopJGet myLoopJGet = new MyLoopJGet(context, "", onLoopJAccessKeyCallComplete, getResources().getString(R.string.url_getaccess_key, getResources().getString(R.string.public_key)));
    }

    private JSONObject jobj;
    /**
     * Get AccessKey call Done.
     */
    MyLoopJGet.OnLoopJGetCallComplete onLoopJAccessKeyCallComplete = new MyLoopJGet.OnLoopJGetCallComplete() {
        @Override
        public void response(String result) {
            try {
                jobj = new JSONObject(result);
                String response_code = jobj.getString("response_code");
                // TODO uncomment this code block
//                if (response_code.equalsIgnoreCase(getResources().getString(R.string.success_code))) {
//                    // success,set the access key here
//                    Utils.setAPIAccessKey(jobj.getString("access_key"), context);
//                    APIAccesskey = jobj.getString("access_key");
//                    getSiteMessages();
//                } else {
//                    try {
//                        Common.showAlertDialog(context, "", jobj.getJSONArray("error").getString(0), true, coordinatorLayout);
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    };
}