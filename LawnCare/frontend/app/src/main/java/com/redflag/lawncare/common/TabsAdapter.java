package com.redflag.lawncare.common;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.redflag.lawncare.book.BookNowFragment;
import com.redflag.lawncare.contact.ContactFragment;
import com.redflag.lawncare.faq.FaqFragment;
import com.redflag.lawncare.home.HomeFragment;


public class TabsAdapter extends FragmentStatePagerAdapter {

    private int tabs;

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
                return new HomeFragment();
            case 1:
                // Book now
                return new BookNowFragment();
            case 2:
                // FAQ
                return new FaqFragment();
            case 3:
                return new ContactFragment();
            default:
                return null;
        }
    }
}

