package com.redflag.lawncare.activities;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.redflag.lawncare.MainActivity;
import com.redflag.lawncare.settings.SettingsActivity;

import org.junit.Rule;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class SettingsActivityTest {
    private SettingsActivity settingsActivity;

    @Rule
    public ActivityTestRule<SettingsActivity> activityActivityTestRule =
            new ActivityTestRule<SettingsActivity>(SettingsActivity.class);


}
