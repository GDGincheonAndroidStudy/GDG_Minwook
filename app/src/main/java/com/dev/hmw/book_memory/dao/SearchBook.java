package com.dev.hmw.book_memory.dao;

/**
 * Created by Bill MinWook Heo on 16. 1. 23..
 */

public class SearchBook {
    /*"title":"[나비북스] 입체팝업북:알라딘과요술램프/백설공주 전 2종 - 누리과정동화/유치원동화/성장발달동화/발달동화/누리과정동화/학습동화/유치원추천도서",
            "link":"http:\/\/www.aladin.co.kr\/shop\/wproduct.aspx?ItemId=73362646&amp;copyPaper=1&amp;ttbkey=ttbpmpmopm11659001",
            "author":"",
            "pubDate":"2015-12-23",
            "description":"",
            "creator":"aladin",
            "isbn":"K682434008",
            "isbn13":"",
            "itemId":73362646,
            "priceSales":96000,
            "priceStandard":96000,
            "stockStatus":"",
            "mileage":960,
            "cover":"http:\/\/image.aladin.co.kr\/product\/7336\/26\/coversum\/scm105404035337.jpg",
            "categoryId":29047,
            "categoryName":"국내도서>전집/중고전집>4-7세>전래/명작동화",
            "publisher":"나비북스",
            "customerReviewRank":0*/

    private String title;
    private String link;
    private String author;

    public String getTitle() {
        return title;
    }

    public SearchBook setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getLink() {
        return link;
    }

    public SearchBook setLink(String link) {
        this.link = link;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public SearchBook setAuthor(String author) {
        this.author = author;
        return this;
    }

    public String getPubDate() {
        return pubDate;
    }

    public SearchBook setPubDate(String pubDate) {
        this.pubDate = pubDate;
        return this;
    }

    public String getDescription() {
        return Description;
    }

    public SearchBook setDescription(String description) {
        Description = description;
        return this;
    }

    public String getCreator() {
        return creator;
    }

    public SearchBook setCreator(String creator) {
        this.creator = creator;
        return this;
    }

    public String getIsbn() {
        return isbn;
    }

    public SearchBook setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public String getCover() {
        return cover;
    }

    public SearchBook setCover(String cover) {
        this.cover = cover;
        return this;
    }

    public String getPublisher() {
        return publisher;
    }

    public SearchBook setPublisher(String publisher) {
        this.publisher = publisher;
        return this;
    }

    private String pubDate;
    private String Description;
    private String creator;
    private String isbn;
    private String cover;
    private String publisher;
}
