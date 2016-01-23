package com.dev.hmw.book_memory.dao;

import java.util.ArrayList;

/**
 * Created by Bill MinWook Heo on 16. 1. 23..
 */
public class SearchBookList {
    /*"version": "20070901",
            "title": "알라딘 검색결과 - aladdin",
            "link": "http:\/\/www.aladin.co.kr\/search\/wsearchresult.aspx?KeyTitle=aladdin&amp;SearchTarget=book",
            "pubDate": "Sat, 23 Jan 2016 03:55:38 GMT",
            "imageUrl": "http:\/\/www.aladin.co.kr\/ucl_editor\/img_secur\/header\/2010\/logo.jpg",
            "totalResults": 215,
            "startIndex": 1,
            "itemsPerPage": 10,
            "query": "aladdin",
            "searchCategoryId": 0,
            "searchCategoryName": "전체",
            "item": [*/

    private String version;
    private String title;
    private String link;
    private String pubDate;
    private String imageUrl;
    private int tatalResults;
    private int startIndex;
    private int itemsPerPage;
    private String query;
    private int searchCategoryId;
    private String searchCategoryName;
    private ArrayList<SearchBook> item;

    public String getVersion() {
        return version;
    }

    public SearchBookList setVersion(String version) {
        this.version = version;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public SearchBookList setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getLink() {
        return link;
    }

    public SearchBookList setLink(String link) {
        this.link = link;
        return this;
    }

    public String getPubDate() {
        return pubDate;
    }

    public SearchBookList setPubDate(String pubDate) {
        this.pubDate = pubDate;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public SearchBookList setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public int getTatalResults() {
        return tatalResults;
    }

    public SearchBookList setTatalResults(int tatalResults) {
        this.tatalResults = tatalResults;
        return this;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public SearchBookList setStartIndex(int startIndex) {
        this.startIndex = startIndex;
        return this;
    }

    public int getItemsPerPage() {
        return itemsPerPage;
    }

    public SearchBookList setItemsPerPage(int itemsPerPage) {
        this.itemsPerPage = itemsPerPage;
        return this;
    }

    public String getQuery() {
        return query;
    }

    public SearchBookList setQuery(String query) {
        this.query = query;
        return this;
    }

    public int getSearchCategoryId() {
        return searchCategoryId;
    }

    public SearchBookList setSearchCategoryId(int searchCategoryId) {
        this.searchCategoryId = searchCategoryId;
        return this;
    }

    public String getSearchCategoryName() {
        return searchCategoryName;
    }

    public SearchBookList setSearchCategoryName(String searchCategoryName) {
        this.searchCategoryName = searchCategoryName;
        return this;
    }

    public ArrayList<SearchBook> getItem() {
        return item;
    }

    public SearchBookList setItem(ArrayList<SearchBook> item) {
        this.item = item;
        return this;
    }
}
