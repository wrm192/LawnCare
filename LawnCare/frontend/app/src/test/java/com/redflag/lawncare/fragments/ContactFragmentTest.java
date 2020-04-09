package com.redflag.lawncare.fragments;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.android21buttons.fragmenttestrule.FragmentTestRule;
import com.redflag.lawncare.R;
import com.redflag.lawncare.book.BookNowFragment;
import com.redflag.lawncare.contact.ContactFragment;

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
public class ContactFragmentTest {

    ContactFragment fragment;

    @Rule
    public FragmentTestRule<?, ContactFragment> fragmentTestRule =
            FragmentTestRule.create(ContactFragment.class);

    @Before
    public void setup(){
        this.fragment = fragmentTestRule.getFragment();
    }

    @Test
    public void shouldShowEditForms() {
        onView(withId(R.id.con_phoneNumE)).check(matches(isDisplayed()));
        onView(withId(R.id.con_emailE)).check(matches(isDisplayed()));
        onView(withId(R.id.con_nameE)).check(matches(isDisplayed()));
        onView(withId(R.id.inquiryInput)).check(matches(isDisplayed()));
    }

    @Test
    public void shouldShowSubmitButton() {
        onView(withId(R.id.submitBtn)).check(matches(isDisplayed()));
    }

    @Test
    public void shouldCheckForEmptyInputs() {

        ViewInteraction phoneNumE  = onView(withId(R.id.con_phoneNumE));
        ViewInteraction emailE  = onView(withId(R.id.con_emailE));
        ViewInteraction nameE  = onView(withId(R.id.con_nameE));
        ViewInteraction inquiry  = onView(withId(R.id.inquiryInput));

        onView(withId(R.id.submitBtn)).perform(click());
        nameE.check(matches(hasErrorText("Field can't be empty")));
        inquiry.check(matches(hasErrorText("Field can't be empty")));
        emailE.check(matches(hasErrorText("Must be a valid email john123@email.com")));
        phoneNumE.check(matches(hasErrorText("Must be valid phone number: 1–123–123–1234")));
    }

    @Test
    public void shouldCheckForValidEmail() {
        ViewInteraction email = onView(withId(R.id.con_emailE)).perform(replaceText("test#notemail"));
        onView(withId(R.id.submitBtn)).perform(click());
        email.check(matches(hasErrorText("Must be a valid email john123@email.com")));
    }


}
