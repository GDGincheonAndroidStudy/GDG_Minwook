package com.dev.hmw.book_memory.ui.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.dev.hmw.book_memory.ui.categoryBookList.BookListFragment;
import com.dev.hmw.book_memory.ui.searchBook.SearchBookFragment;

/**
 * Created by Heo Minwook on 2016-01-15.
 */
public class BookPagerAdapter extends FragmentStatePagerAdapter {

    public BookPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment resultFragment = null;

        switch (position) {
            case 0:
                resultFragment = BookListFragment.newInstance(position);
                break;
            case 1:
                resultFragment = SearchBookFragment.newInstance();
        }
        return resultFragment;
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
