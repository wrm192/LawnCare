package com.redflag.lawncare.services;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.redflag.lawncare.MainActivity;
import com.redflag.lawncare.common.recaptcha.VerificationService;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class VerificationServiceTest {

    VerificationService verificationService;
    MainActivity mainActivity;

    @Rule
    public ActivityTestRule<MainActivity> activityActivityTestRule =
            new ActivityTestRule<MainActivity>(MainActivity.class);

    @Before
    public void setup() {
        mainActivity = activityActivityTestRule.getActivity();
    }

    @Test
    public void test() {

    }
}
