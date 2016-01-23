package com.dev.hmw.book_memory.network;

import com.dev.hmw.book_memory.dao.BestSellerBookList;
import com.dev.hmw.book_memory.dao.SearchBookList;

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

    @FormUrlEncoded
    @POST("ItemSearch.aspx")
    Call<SearchBookList> searchBook(@Field("ttbkey") String ttbKey,
                                    @Field("Query") String Query,
                                    @Field("QueryType") String QueryType,
                                    @Field("MaxResults") int MaxResults,
                                    @Field("start") int start,
                                    @Field("SearchTarget") String SearchTarget,
                                    @Field("output") String output,
                                    @Field("Version") int Version);



}
