package com.redflag.lawncare.activities;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.redflag.lawncare.settings.SettingsActivity;
import com.redflag.lawncare.splash.SplashActivity;

import org.junit.Rule;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class SplashTestActivity {
    SplashActivity splashActivity;

    @Rule
    public ActivityTestRule<SplashActivity> activityActivityTestRule =
            new ActivityTestRule<SplashActivity>(SplashActivity.class);
}
