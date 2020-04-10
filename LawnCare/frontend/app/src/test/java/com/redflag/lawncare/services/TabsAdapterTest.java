package com.redflag.lawncare.services;

import androidx.fragment.app.Fragment;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.redflag.lawncare.MainActivity;
import com.redflag.lawncare.book.BookNowFragment;
import com.redflag.lawncare.common.TabsAdapter;
import com.redflag.lawncare.contact.ContactFragment;
import com.redflag.lawncare.faq.FaqFragment;
import com.redflag.lawncare.home.HomeFragment;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(AndroidJUnit4.class)
public class TabsAdapterTest {

    private final int TABS = 4;
    private TabsAdapter tabsAdapter;
    @Rule
    public ActivityTestRule<MainActivity> activityActivityTestRule =
            new ActivityTestRule<MainActivity>(MainActivity.class);

    @Before
    public void setup() {
        tabsAdapter = new TabsAdapter(activityActivityTestRule.getActivity().getSupportFragmentManager(),  TABS);
    }

    @Test
    public void shouldHave4Tabs(){
        assertEquals(tabsAdapter.getCount(),  TABS);
    }

    @Test
    public void shouldReturnHomeFragment(){
        assertTrue(tabsAdapter.getItem(0) instanceof HomeFragment);
    }

    @Test
    public void shouldReturnBookNowFragment(){
        assertTrue(tabsAdapter.getItem(1) instanceof BookNowFragment);
    }

    @Test
    public void shouldReturnFAQFragment(){
        assertTrue(tabsAdapter.getItem(2) instanceof FaqFragment);
    }

    @Test
    public void shouldReturnContactFragment(){
        assertTrue(tabsAdapter.getItem(3) instanceof ContactFragment);
    }

    @Test
    public void shouldReturnNull() {
        assertNull(tabsAdapter.getItem(TABS + 1)); // out of range)
        assertNull(tabsAdapter.getItem(0 - 1)); // out of range)
    }

}
