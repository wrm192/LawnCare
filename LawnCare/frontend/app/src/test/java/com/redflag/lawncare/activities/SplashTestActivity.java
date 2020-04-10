package com.redflag.lawncare.activities;

import android.content.Intent;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.redflag.lawncare.MainActivity;
import com.redflag.lawncare.settings.SettingsActivity;
import com.redflag.lawncare.splash.SplashActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.shadows.ShadowLooper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.robolectric.Shadows.shadowOf;

@RunWith(AndroidJUnit4.class)
public class SplashTestActivity {
    //SplashActivity splashActivity;

    /*@Rule
    public ActivityTestRule<SplashActivity> activityActivityTestRule =
            new ActivityTestRule<SplashActivity>(SplashActivity.class);
*/
    @Before
    public void setup() {
        //this.splashActivity = activityActivityTestRule.getActivity();
    }

    @Test
    public void checkSplashHasLimitedLife(){
        ActivityController<SplashActivity> controller = Robolectric.buildActivity(SplashActivity.class).create().start();

        ShadowLooper.runUiThreadTasksIncludingDelayedTasks();

        SplashActivity splashScreenActivity = controller.get();
        assertTrue(splashScreenActivity.isFinishing());
    }
}
