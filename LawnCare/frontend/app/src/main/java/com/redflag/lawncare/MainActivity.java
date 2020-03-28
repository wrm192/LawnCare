package com.redflag.lawncare;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.redflag.lawncare.Contact.ContactActivity;


public class MainActivity extends AppCompatActivity {

    /*public MainActivity(FragmentManager fm) {
        super(fm);
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
    }

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
}
