package com.example.andela.lukaround.adapters;

/**
 * Created by andela on 11/21/15.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hp1 on 21-01-2015.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    List<Fragment> fragmentList;
    // Build a Constructor and assign the passed Values to appropriate values in the class
    public ViewPagerAdapter(FragmentManager fm,List<Fragment> fragmentArrayList) {
        super(fm);
        fragmentList=fragmentArrayList;

    }

    //This method return the fragment for the every position in the View Pager
    @Override
    public Fragment getItem(int position) {
        if(position<0 || position>=fragmentList.size())
            throw new ArrayIndexOutOfBoundsException("the size of the list is less than the position entered");
        return fragmentList.get(position);

    }

    // This method return the titles for the Tabs in the Tab Strip

    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentList.get(position).toString();
    }

    // This method return the Number of tabs for the tabs Strip

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}