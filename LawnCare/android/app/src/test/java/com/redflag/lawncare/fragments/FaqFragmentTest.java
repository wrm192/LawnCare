package com.redflag.lawncare.fragments;

import android.view.View;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.android21buttons.fragmenttestrule.FragmentTestRule;
import com.redflag.lawncare.MainActivity;
import com.redflag.lawncare.R;
import com.redflag.lawncare.book.BookNowFragment;
import com.redflag.lawncare.faq.FaqFragment;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class FaqFragmentTest {

    @Rule
    public FragmentTestRule<?, FaqFragment> fragmentTestRule =
            FragmentTestRule.create(FaqFragment.class);
    private FaqFragment faqFragment = null;

    @Before
    public void setUp() {
        this.faqFragment = fragmentTestRule.getFragment();
    }

    @Test
    public void shouldShowFaq(){
        onView(withId(R.id.listView)).check(matches(isDisplayed()));
        //onView(withId(R.id.question)).check(matches(isDisplayed()));
        //onView(withId(R.id.answer)).check(matches(isDisplayed()));
    }

    @After
    public void tearDown(){
        faqFragment = null;
    }
}