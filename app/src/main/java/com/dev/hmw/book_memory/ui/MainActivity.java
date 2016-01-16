package com.dev.hmw.book_memory.ui;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.AbsListView;
import android.widget.ListView;

import com.dev.hmw.book_memory.R;
import com.dev.hmw.book_memory.dao.BestSellerBookList;
import com.dev.hmw.book_memory.network.ApiClient;
import com.dev.hmw.book_memory.network.NetworkManager;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends Activity {

    ListView listView;
    String ttbKey = "ttbpmpmopm11659001";
    private int startPage = 1;
    private BestSellerListAdapter bestSellerListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.testList);


        bestSellerListAdapter = new BestSellerListAdapter(getApplicationContext());


        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int scrollState) {
                int count = listView.getCount();
                Log.d("bookTest", "scroll state : " + SCROLL_STATE_IDLE);
                if (scrollState == SCROLL_STATE_IDLE) {
                    Log.d("bookTest", "position : " + listView.getLastVisiblePosition() + " , count " +
                            ":" + count);
                    if (listView.getLastVisiblePosition() >= count - 1) {
                        Log.d("bookTest", "scrollstate bottom");
                        getBestSellerList(startPage, false);
                        startPage++;
                    }
                }
            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {
                Log.d("bookTest", "onScroll");
            }
        });

        getBestSellerList(startPage, true);
//        List<BestSellerBook> bestSellerBookList = restAdapter.create(ApiClient.class)
//                .bestSellerBookList(
//                        ttbKey, "Bestseller", 10, 1, "book", "js", 20131101
//
//                );
//
//
//        BestSellerListAdapter bestSellerListAdapter = new BestSellerListAdapter(getApplicationContext(), bestSellerBookList);
//
//        listView.setAdapter(bestSellerListAdapter);
    }

    private void addItem() {


    }

    private void getBestSellerList(int startIndex, final boolean first) {

        ApiClient apiClient = NetworkManager.getIntance().getRetrofit(ApiClient.class);


        Call<BestSellerBookList> call = apiClient.bestSellerBookList(ttbKey, "Bestseller", 15, startIndex, "book", "js", 20131101);

        call.enqueue(new Callback<BestSellerBookList>() {
            @Override
            public void onResponse(Response<BestSellerBookList> response, Retrofit retrofit) {
                Log.d("bookTest", "network success");

                /*BestSellerBookList bestSellerBookList = response.body();
                bestSellerListAdapter.setList(bestSellerBookList.getItem());

                if (first == true) {
                    listView.setAdapter(bestSellerListAdapter);
                } else {
                    bestSellerListAdapter.notifyDataSetChanged();
                }*/
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
