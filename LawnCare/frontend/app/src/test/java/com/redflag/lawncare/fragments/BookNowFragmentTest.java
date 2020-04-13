package com.redflag.lawncare.fragments;


import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.android21buttons.fragmenttestrule.FragmentTestRule;
import com.redflag.lawncare.R;
import com.redflag.lawncare.book.BookNowFragment;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasErrorText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class BookNowFragmentTest {
    BookNowFragment fragment;

    @Rule
    public FragmentTestRule<?, BookNowFragment> fragmentTestRule =
            FragmentTestRule.create(BookNowFragment.class);


    @Before
    public void setup() {
        this.fragment = fragmentTestRule.getFragment();
    }

    @Test
    public void shouldShowButton() throws Exception {
        onView(ViewMatchers.withId(R.id.bookNowButton)).check(matches(isDisplayed()));
    }

    @Test
    public void shouldShowEditForms() {
        onView(withId(R.id.name)).check(matches(isDisplayed()));
        onView(withId(R.id.phoneNum)).check(matches(isDisplayed()));
        onView(withId(R.id.address)).check(matches(isDisplayed()));
    }

    @Test
    public void shouldFailToSendWithEmptyStrings() {
        onView(withId(R.id.bookNowButton)).perform(click());
        ViewInteraction nameE = onView(withId(R.id.nameE));
        ViewInteraction addressE = onView(withId(R.id.addressE));
        ViewInteraction phoneNumE = onView(withId(R.id.phoneNumE));

        nameE.check(matches(hasErrorText("Field can't be empty")));
        addressE.check(matches(hasErrorText("Field can't be empty")));
        phoneNumE.check(matches(hasErrorText("Must be valid phone number: 1–123–123–1234")));
    }

    @Test
    public void shouldCheckForValidPhoneNumber() {
        ViewInteraction phoneNumE = onView(withId(R.id.phoneNumE)).perform(replaceText("1"));
        onView(withId(R.id.bookNowButton)).perform(click());
        phoneNumE.check(matches(hasErrorText("Must be valid phone number: 1–123–123–1234")));
    }

    //@Test Test Broken, starting  recaptcha causing a cast error. since its references the main activity.
    public void shouldStartRecaptcha() {
        ViewInteraction phoneNumE = onView(withId(R.id.phoneNumE)).perform(replaceText("1-123-123-1234"));
        ViewInteraction addressE = onView(withId(R.id.addressE)).perform(replaceText("Valid address"));
        ViewInteraction name = onView(withId(R.id.nameE)).perform(replaceText("valid name"));

        onView(withId(R.id.bookNowButton)).perform(click());

        //intended(toPackage("com.redflag.lawncare.common.recaptcha"));
    }

}
