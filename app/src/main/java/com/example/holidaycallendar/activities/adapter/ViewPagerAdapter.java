package com.example.holidaycallendar.activities.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.holidaycallendar.activities.fragment.FragmentMonthly;
import com.example.holidaycallendar.activities.fragment.FragmentNow;


public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    public ViewPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new FragmentNow();
                break;
            case 1:
                fragment = new FragmentMonthly();
                break;
        }
        assert fragment != null;
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String strTitle = "";
        switch (position) {
            case 0:
                strTitle = "Tahun Ini";
                break;
            case 1:
                strTitle = "Per Bulan";
                break;
        }
        return strTitle;
    }

}