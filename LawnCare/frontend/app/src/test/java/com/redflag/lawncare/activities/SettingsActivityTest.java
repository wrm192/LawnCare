package com.redflag.lawncare.activities;

import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.redflag.lawncare.MainActivity;
import com.redflag.lawncare.R;
import com.redflag.lawncare.settings.SettingsActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withSpinnerText;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class SettingsActivityTest {
    private SettingsActivity settingsActivity;
    private Spinner spinner;
    private SpinnerAdapter spinnerAdapter;

    @Rule
    public ActivityTestRule<SettingsActivity> activityActivityTestRule =
            new ActivityTestRule<SettingsActivity>(SettingsActivity.class);

    @Before
    public void setup(){
        this.settingsActivity = activityActivityTestRule.getActivity();
        spinner = (Spinner)settingsActivity.findViewById(R.id.spinner);
        spinnerAdapter = spinner.getAdapter();
    }

    @Test
    public void defaultShouldBeBlank() {
        onView(withId(R.id.spinner)).check(matches(isDisplayed()));
        onView(withId(R.id.spinner)).check(matches(withSpinnerText(containsString(" "))));
    }

    @Test
    public void testSpinnerConditions() {
        assertTrue(spinner.getOnItemSelectedListener() != null);
        assertTrue(spinnerAdapter != null);
        assertEquals(spinnerAdapter.getCount(), 3);
    }

    @Test
    public void shouldDisplayText() {
        onView(withId(R.id.localeLabel)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
    }

    @Test
    public void testSpinnerValues() {
        onView(withId(R.id.spinner)).perform(click());
       /* onData(allOf(is(instanceOf(String.class)), is("English")))
                .perform(click());
        assertTrue(settingsActivity.isDestroyed());
*/
    }


}
