package com.dev.hmw.book_memory.network;

import com.dev.hmw.book_memory.dao.BestSellerBookList;

import retrofit.Call;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by Bill MinWook Heo on 15. 7. 21..
 */
public interface ApiClient {

    @FormUrlEncoded
    @POST("ItemList.aspx")
    Call<BestSellerBookList> bestSellerBookList(@Field("ttbkey") String ttbKey,
                                                @Field("QueryType") String queryType,
                                                @Field("MaxResults") int maxResults,
                                                @Field("start") int start,
                                                @Field("SearchTarget") String searchTarget,
                                                @Field("output") String output,
                                                @Field("Version") int version);
}
