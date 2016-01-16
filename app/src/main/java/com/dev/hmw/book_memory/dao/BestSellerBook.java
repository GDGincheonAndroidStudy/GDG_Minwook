package com.dev.hmw.book_memory.dao;

/**
 * Created by Bill MinWook Heo on 15. 7. 29..
 */
//@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class BestSellerBook {

    String title;
    String pubDate;
    String author;
    String description;
    String isbn;
    String publisher;
    String cover;
    String subTitle;
    String originalTitle;

    public String getTitle() {
        return title;
    }

    public BestSellerBook setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getPubDate() {
        return pubDate;
    }

    public BestSellerBook setPubDate(String pubDate) {
        this.pubDate = pubDate;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public BestSellerBook setAuthor(String author) {
        this.author = author;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public BestSellerBook setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getIsbn() {
        return isbn;
    }

    public BestSellerBook setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public String getPublisher() {
        return publisher;
    }

    public BestSellerBook setPublisher(String publisher) {
        this.publisher = publisher;
        return this;
    }

    public String getCover() {
        return cover;
    }

    public BestSellerBook setCover(String cover) {
        this.cover = cover;
        return this;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public BestSellerBook setSubTitle(String subTitle) {
        this.subTitle = subTitle;
        return this;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public BestSellerBook setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
        return this;
    }
}
