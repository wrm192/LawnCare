package com.redflag.lawncare;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.safetynet.SafetyNet;
import com.google.android.gms.safetynet.SafetyNetApi;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.tabs.TabLayout;
import com.redflag.lawncare.common.TabsApadater;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;


public class MainActivity extends AppCompatActivity {

    private final String TAG="CAPTCHA";

    private TextView textView1;
    private CheckBox checkBox;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        checkBox = (CheckBox)findViewById(R.id.checkBox);

        TabLayout tabLayout = findViewById(R.id.bottomTab);
        tabLayout.addTab(tabLayout.newTab().setText("Contact"));
        tabLayout.addTab(tabLayout.newTab().setText("Book"));
        tabLayout.addTab(tabLayout.newTab().setText("FAQ"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        TabLayout.Tab tab = tabLayout.getTabAt(1);
        tab.select();
        TabsApadater tabsApadater = new TabsApadater(getSupportFragmentManager(), tabLayout.getTabCount());
        final ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPager.setAdapter(tabsApadater);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        viewPager.setCurrentItem(1);
        tabLayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) { }
            @Override
            public void onTabReselected(TabLayout.Tab tab) { }
        });

        setSupportActionBar(toolbar);


        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckCaptchaBox(isChecked);
            }
        });

    }

    //Client side code for captcha
    private void CheckCaptchaBox(boolean isChecked) {
        if (isChecked) {
            SafetyNet.getClient(this).verifyWithRecaptcha("6Lf5nOQUAAAAAIiUBfbb_2Tb5_fm7905Bts5zIYn")
                    .addOnSuccessListener(this, new OnSuccessListener<SafetyNetApi.RecaptchaTokenResponse>() {
                                @Override
                                public void onSuccess(SafetyNetApi.RecaptchaTokenResponse response) {
                                    // Indicates communication with reCAPTCHA service was
                                    // successful.
                                    String userResponseToken = response.getTokenResult();
                                    if (!userResponseToken.isEmpty()) {
                                        // Validate the user response token using the
                                        // reCAPTCHA siteverify API.
                                        handleSiteVerify(response.getTokenResult());
                                    }
                                }
                            })
                    .addOnFailureListener(this, new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            if (e instanceof ApiException) {
                                // An error occurred when communicating with the
                                // reCAPTCHA service. Refer to the status code to
                                // handle the error appropriately.
                                ApiException apiException = (ApiException) e;
                                int statusCode = apiException.getStatusCode();
                                Log.d(TAG, "Error: " + CommonStatusCodes
                                        .getStatusCodeString(statusCode));
                            } else {
                                // A different, unknown type of error occurred.
                                Log.d(TAG, "Error: " + e.getMessage());
                            }
                        }
                    });
        }
    }

    //Server side code for captcha
    private void handleSiteVerify(String tokenResult) {

        textView1.setText(tokenResult);


    }

    private class MyNetworkCode extends AsyncTask<String,Void,Void> {

        ProgressDialog progressDialog;
        BufferedReader bufferedReader;
        BufferedWriter bufferedWriter;
        InputStream inputStream;
        OutputStream outputStream;
        InputStreamReader inputStreamReader;
        OutputStreamWriter outputStreamWriter;

        HttpsURLConnection httpsURLConnection;
        URL url;

        @Override
        protected Void doInBackground(String... strings) {
            return null;
        }

    }

}
