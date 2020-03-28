package com.redflag.lawncare;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
<<<<<<< HEAD
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.redflag.lawncare.common.TabsApadater;

=======
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.redflag.lawncare.Contact.ContactActivity;
>>>>>>> 3656ac683c97f72b1a721c9761ac2dcb70e96e13


public class MainActivity extends AppCompatActivity {

    /*public MainActivity(FragmentManager fm) {
        super(fm);
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);

        TabLayout tabLayout = findViewById(R.id.bottomTab);
        tabLayout.addTab(tabLayout.newTab().setText("Contact"));
        tabLayout.addTab(tabLayout.newTab().setText("Book"));
        tabLayout.addTab(tabLayout.newTab().setText("FAQ"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        TabLayout.Tab tab = tabLayout.getTabAt(1);
        tab.select();
        TabsApadater tabsApadater = new TabsApadater(getSupportFragmentManager(), tabLayout.getTabCount());
        final ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPager.setAdapter(tabsApadater);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        viewPager.setCurrentItem(1);
        tabLayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) { }
            @Override
            public void onTabReselected(TabLayout.Tab tab) { }
        });

        setSupportActionBar(toolbar);
    }

<<<<<<< HEAD
=======
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    ContactActivity Contact = new ContactActivity();
                    return Contact;
                case 1:
                    ContactActivity Contact2 = new ContactActivity();
                    return Contact2;
                case 2:
                    ContactActivity Contact3 = new ContactActivity();
                    return Contact3;

            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position){
            switch (position) {
                case 0:
                    return "CONTACT";
                case 1:
                    return "BOOK NOW";
                case 2:
                    return "FAQ";
            }
            return null;
        }
    }

    /*@Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                ContactActivity Contact = new ContactActivity();
                return Contact;
            case 1:
                ContactActivity Contact2 = new ContactActivity();
                return Contact2;
            case 2:
                ContactActivity Contact3 = new ContactActivity();
                return Contact3;

        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }*/
>>>>>>> 3656ac683c97f72b1a721c9761ac2dcb70e96e13
}
