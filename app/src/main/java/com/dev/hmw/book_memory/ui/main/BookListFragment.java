package com.dev.hmw.book_memory.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dev.hmw.book_memory.R;
import com.dev.hmw.book_memory.dao.BestSellerBook;
import com.dev.hmw.book_memory.dao.BestSellerBookList;
import com.dev.hmw.book_memory.define.Define;
import com.dev.hmw.book_memory.network.ApiClient;
import com.dev.hmw.book_memory.network.NetworkManager;

import java.util.ArrayList;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by Heo Minwook on 2016-01-15.
 */
public class BookListFragment extends Fragment {
    private static final String TAB_POSITION = "tab_position";
    private BookListAdapter bookListAdapter;


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
        /*for (int i = 0; i < 50; i++) {
            //items.add("Tab #" + tabPosition + " item #" + i);
            BestSellerBook bestSellerBook = new BestSellerBook();
            bestSellerBook.setTitle("Tab #" + tabPosition + " item #" + i);
            items.add(bestSellerBook);
        }*/

        View v = inflater.inflate(R.layout.fragment_book_list_view, container, false);
        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.recyclerview);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(linearLayoutManager);

        bookListAdapter = new BookListAdapter(items, getContext());
        recyclerView.setAdapter(bookListAdapter);

        getBestSellerList(1, true);

        return v;
    }

    private void getBestSellerList(int startIndex, final boolean first) {

        ApiClient apiClient = NetworkManager.getIntance().getRetrofit(ApiClient.class);


        Call<BestSellerBookList> call = apiClient.bestSellerBookList(Define.ttbKey, "Bestseller", 15,
                startIndex, "book", "js", 20131101);

        call.enqueue(new Callback<BestSellerBookList>() {
            @Override
            public void onResponse(Response<BestSellerBookList> response, Retrofit retrofit) {
                Log.d("bookTest", "network success");

                BestSellerBookList bestSellerBookList = response.body();

                bookListAdapter.setmItems(bestSellerBookList.getItem());

                bookListAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e("bookTest", "network failure");
                Log.e("bookTest", t.getMessage());
                Log.e("bookTest", t.toString());
                t.printStackTrace();
            }
        });

    }
}