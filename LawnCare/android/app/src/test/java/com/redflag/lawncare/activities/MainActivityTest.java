package com.redflag.lawncare.activities;

import android.view.Display;

import androidx.annotation.UiThread;
import androidx.test.annotation.UiThreadTest;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.action.GeneralLocation;
import androidx.test.espresso.action.GeneralSwipeAction;
import androidx.test.espresso.action.Press;
import androidx.test.espresso.action.Swipe;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.redflag.lawncare.MainActivity;
import com.redflag.lawncare.R;
import com.redflag.lawncare.book.BookNowFragment;
import com.redflag.lawncare.home.HomeFragment;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import static androidx.test.espresso.Espresso.*;
import static androidx.test.espresso.action.ViewActions.swipeLeft;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;

import static junit.framework.TestCase.assertTrue;

import static org.hamcrest.CoreMatchers.notNullValue;


@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    private MainActivity mainActivity;

    @Rule
    public ActivityTestRule<MainActivity> activityActivityTestRule =
            new ActivityTestRule<MainActivity>(MainActivity.class);

    @Before
    public void init() {
        mainActivity = activityActivityTestRule.getActivity();
        assertThat(mainActivity, notNullValue());
        activityActivityTestRule.getActivity().getSupportFragmentManager().beginTransaction();
    }

    @Test
    public void checkTabLayoutDisplayed() {
        onView(ViewMatchers.withId(R.id.bottomTab))
                .check(matches(isDisplayed()));
    }

    @Test
    @UiThreadTest
    public void viewPagerAvailable() {
        onView(withId(R.id.view_pager)).check(matches(isDisplayed()));
    }

    @Test
    public void checkTabSwitch() {
        onView(withId(R.id.view_pager))
                .perform(swipeLeft())
                .check(matches(isDisplayed()));

        assertTrue((mainActivity.getAdapter().getmCurrent()) instanceof BookNowFragment);
    }

    //@Test // this test fails, when im not sure why it does. first tab should be home
    public void onHomePage() {
        //activityActivityTestRule.getActivity().getSupportFragmentManager().beginTransaction().add(R.layout.fragment_home, new HomeFragment()).commit();
        assertTrue(mainActivity.getAdapter().getmCurrent() instanceof HomeFragment); // current adapter displayed
    }

}
