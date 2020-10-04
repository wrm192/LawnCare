package com.redflag.lawncare.common;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.redflag.lawncare.book.BookNowFragment;
import com.redflag.lawncare.calculation.CalculationFragment;
import com.redflag.lawncare.contact.ContactFragment;
import com.redflag.lawncare.faq.FaqFragment;
import com.redflag.lawncare.home.HomeFragment;


public class TabsAdapter extends FragmentStatePagerAdapter {

    private int tabs;
    private Fragment mCurrent;

    public TabsAdapter(@NonNull FragmentManager fm, int tabs) {
        super(fm);
        this.tabs = tabs;
    }

    @Override
    public int getCount() {
        return tabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                // Contact
                mCurrent = new HomeFragment();
                return mCurrent;
            case 1:
                // Book now
                mCurrent = new BookNowFragment();
                return mCurrent;
            case 2:
                // FAQ
                mCurrent = new FaqFragment();
                return mCurrent;
            case 3:
                // Contact
                mCurrent = new ContactFragment();
                return mCurrent;
            case 4:
                //Calculation
                mCurrent = new CalculationFragment();
                return mCurrent;
            default:
                return null;
        }
    }

    public Fragment getmCurrent() {
        return mCurrent;
    }
}

