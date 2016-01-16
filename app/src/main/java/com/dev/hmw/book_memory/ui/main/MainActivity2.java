package com.dev.hmw.book_memory.ui.main;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.dev.hmw.book_memory.R;
import com.dev.hmw.book_memory.dao.BestSellerBookList;
import com.dev.hmw.book_memory.network.ApiClient;
import com.dev.hmw.book_memory.network.NetworkManager;
import com.dev.hmw.book_memory.ui.BestSellerListAdapter;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity2 extends AppCompatActivity {

    ListView listView;
    String ttbKey = "ttbpmpmopm11659001";
    private int startPage = 1;
    private BestSellerListAdapter bestSellerListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        actionBar.setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(findViewById(R.id.coordinator), "I'm a Snackbar", Snackbar.LENGTH_LONG).setAction("Action", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity2.this, "Snackbar Action", Toast.LENGTH_LONG).show();
                    }
                }).show();
            }
        });

        BookPagerAdapter adapter = new BookPagerAdapter(getSupportFragmentManager());
        ViewPager viewPager = (ViewPager)findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = (TabLayout)findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);
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
