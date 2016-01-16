package com.dev.hmw.book_memory.ui.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Heo Minwook on 2016-01-15.
 */
public class BookPagerAdapter extends FragmentStatePagerAdapter {

    public BookPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return BookListFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Tab " + position;
    }
}
