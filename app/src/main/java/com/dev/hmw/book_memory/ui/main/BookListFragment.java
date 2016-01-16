package com.dev.hmw.book_memory.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dev.hmw.book_memory.R;
import com.dev.hmw.book_memory.dao.BestSellerBook;

import java.util.ArrayList;

/**
 * Created by Heo Minwook on 2016-01-15.
 */
public class BookListFragment extends Fragment {
    private static final String TAB_POSITION = "tab_position";

    public BookListFragment() {
    }

    public static BookListFragment newInstance(int tabPosition) {
        BookListFragment fragment = new BookListFragment();
        Bundle args = new Bundle();
        args.putInt(TAB_POSITION, tabPosition);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle args = getArguments();
        int tabPosition = args.getInt(TAB_POSITION);

        ArrayList<BestSellerBook> items = new ArrayList<BestSellerBook>();
        for (int i = 0; i < 50; i++) {
            //items.add("Tab #" + tabPosition + " item #" + i);
            BestSellerBook bestSellerBook = new BestSellerBook();
            bestSellerBook.setTitle("Tab #" + tabPosition + " item #" + i);
            items.add(bestSellerBook);
        }

        View v =  inflater.inflate(R.layout.fragment_book_list_view, container, false);
        RecyclerView recyclerView = (RecyclerView)v.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new BookListAdapter(items, getContext()));

        return v;
    }
}