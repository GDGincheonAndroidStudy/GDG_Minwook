package com.dev.hmw.book_memory.network;

import com.dev.hmw.book_memory.define.Define;

import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;


/**
 * Created by Heo Minwook on 2015-12-08.
 */
public class NetworkManager {

    private static final NetworkManager networkManager = new NetworkManager();

    private NetworkManager() {
    }

    public static NetworkManager getIntance() {
        return networkManager;
    }

    public <T> T getRetrofit(Class<T> aa) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Define.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(aa);
    }
}
