package com.example.bookapptemplate;

public class BookModel {
    private String title;
    private String author;
    private String description;
    private String imgUrl;
    private int pages;
    private int reviews;
    private int drawableImage;


    public BookModel() { }

    public BookModel(String title, String author, String description, String imgUrl, int pages, int reviews, int drawableImage) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.imgUrl = imgUrl;
        this.pages = pages;
        this.reviews = reviews;
        this.drawableImage = drawableImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getReviews() {
        return reviews;
    }

    public void setReviews(int reviews) {
        this.reviews = reviews;
    }

    public int getDrawableImage() {
        return drawableImage;
    }

    public void setDrawableImage(int drawableImage) {
        this.drawableImage = drawableImage;
    }
}
