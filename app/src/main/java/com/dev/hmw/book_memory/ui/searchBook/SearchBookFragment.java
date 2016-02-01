package com.dev.hmw.book_memory.ui.searchBook;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.dev.hmw.book_memory.R;
import com.dev.hmw.book_memory.dao.SearchBook;
import com.dev.hmw.book_memory.dao.SearchBookList;
import com.dev.hmw.book_memory.define.Define;
import com.dev.hmw.book_memory.network.ApiClient;
import com.dev.hmw.book_memory.network.NetworkManager;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by Bill MinWook Heo on 16. 1. 23..
 */
public class SearchBookFragment extends Fragment implements View.OnClickListener {
    private SearchListAdapter searchListAdapter;
    private EditText searchInputText;

    public SearchBookFragment() {

    }

    public static SearchBookFragment newInstance() {
        SearchBookFragment fragment = new SearchBookFragment();
        Bundle args = new Bundle();
        //args.putInt(TAB_POSITION, tabPosition);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle args = getArguments();
        Log.d("book", "SearchBookFragment onCreateView!@!!");
        ArrayList<SearchBook> items = new ArrayList<SearchBook>();
        /*for (int i = 0; i < 50; i++) {
            //items.add("Tab #" + tabPosition + " item #" + i);
            BestSellerBook bestSellerBook = new BestSellerBook();
            bestSellerBook.setTitle("Tab #" + tabPosition + " item #" + i);
            items.add(bestSellerBook);
        }*/

        View v = inflater.inflate(R.layout.fragment_search_book, container, false);
        Log.d("book", "63");
        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.rv_search_book_list);
        searchInputText = (EditText) v.findViewById(R.id.et_search_input);
        Button btnComfirm = (Button) v.findViewById(R.id.bt_search_comfirm);
        btnComfirm.setOnClickListener(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        searchListAdapter = new SearchListAdapter(items, getContext());
        recyclerView.setAdapter(searchListAdapter);

        //getBestSellerList(1, "");
        return v;
    }

    private void getBestSellerList(int startIndex, String searchText) {

        ApiClient apiClient = NetworkManager.getIntance().getRetrofit(ApiClient.class);

        Call<SearchBookList> call = apiClient.searchBook(Define.ttbKey, searchText, "Title",
                10, startIndex, "Book", "js", 20070901);

        call.enqueue(new Callback<SearchBookList>() {
            @Override
            public void onResponse(Response<SearchBookList> response) {
                Log.d("bookTest", "network success");

                SearchBookList searchBookList = response.body();

                searchListAdapter.setmItems(searchBookList.getItem());

                searchListAdapter.notifyDataSetChanged();
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_search_comfirm:
                if (!TextUtils.isEmpty(searchInputText.getText())) {
                    getBestSellerList(1, searchInputText.getText().toString());
                }

        }

    }
}
