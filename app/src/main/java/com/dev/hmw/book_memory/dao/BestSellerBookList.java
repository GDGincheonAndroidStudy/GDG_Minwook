package com.dev.hmw.book_memory.dao;

import java.util.List;

/**
 * Created by Bill MinWook Heo on 15. 8. 3..
 */
public class BestSellerBookList {

    private String version;
    private String logo;
    private String title;
    private String link;
    private String pubDate;
    private int totalResults;

    private int startIndex;
    private int itemsPerPage;
    private String query;
    private int searchCategoryId;
    private String searchCategoryName;

    private List<BestSellerBook> item;

    public BestSellerBookList() {
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getItemsPerPage() {
        return itemsPerPage;
    }

    public void setItemsPerPage(int itemsPerPage) {
        this.itemsPerPage = itemsPerPage;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public int getSearchCategoryId() {
        return searchCategoryId;
    }

    public void setSearchCategoryId(int searchCategoryId) {
        this.searchCategoryId = searchCategoryId;
    }

    public String getSearchCategoryName() {
        return searchCategoryName;
    }

    public void setSearchCategoryName(String searchCategoryName) {
        this.searchCategoryName = searchCategoryName;
    }

    public List<BestSellerBook> getItem() {
        return item;
    }

    public void setItem(List<BestSellerBook> item) {
        this.item = item;
    }
}
