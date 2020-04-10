package com.redflag.lawncare.fragments;

import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.android21buttons.fragmenttestrule.FragmentTestRule;
import com.redflag.lawncare.R;
import com.redflag.lawncare.book.BookNowFragment;
import com.redflag.lawncare.home.HomeFragment;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(AndroidJUnit4.class)
public class HomeFragmentTest {
    // very Little to test on this one, not actions occurs. simplest fragment
    HomeFragment homeFragment;
    @Rule
    public FragmentTestRule<?, HomeFragment> fragmentTestRule =
            FragmentTestRule.create(HomeFragment.class);

    @Before
    public void setup() {
        this.homeFragment = fragmentTestRule.getFragment();
    }

    @Test
    public void shouldDisplayHeader() {
        onView(withId(R.id.homeHeader)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
    }

    @Test
    public void shouldDisplayInfo() {
        onView(withId(R.id.info)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
    }

    @Test
    public void shouldDisplayPicture() {
        onView(withId(R.id.logo)).check(matches(isDisplayed()));
    }
}
