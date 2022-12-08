package com.company;

public class Paper {
    private PageSize pageSize;
    private PaperType paperType;
    private double pricePerList;

    public Paper(PageSize pageSize, PaperType paperType) {
        this.pageSize = pageSize;
        this.paperType = paperType;
        this.pricePerList = pageSize.getPricePerPage()+paperType.getPricePerType();
    }

    public PageSize getPageSize() {
        return pageSize;
    }

    public PaperType getPaperType() {
        return paperType;
    }

    public double getPricePerList() {
        return pricePerList;
    }
}
