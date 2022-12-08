package com.company;

public class Edition {
    private String title;
    private EditionType editionType;
    private int numberOfPages;
    private PageSize pageSize;
    private double sellingPrice;

    public Edition(String title, EditionType editionType, int numberOfPages, PageSize pageSize, double sellingPrice) {
        this.title = title;
        this.editionType = editionType;
        this.numberOfPages = numberOfPages;
        this.pageSize = pageSize;
        this.sellingPrice = sellingPrice;
    }

    public String getTitle() {
        return title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public PageSize getPageSize() {
        return pageSize;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    @Override
    public String toString() {
        return "Edition{" +
                "title='" + title + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", pageSize=" + pageSize +
                ", sellingPrice=" + sellingPrice +
                '}';
    }
}