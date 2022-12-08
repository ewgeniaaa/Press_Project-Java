package com.company;

public enum PageSize {
    A1(3.), A2(2.), A3(1.5), A4(0.5), A5(0.2);

    private double pricePerPage;

    PageSize(double pricePerPage) {
        this.pricePerPage = pricePerPage;
    }

    public void setPricePerPage(double pricePerPage) {
        this.pricePerPage = pricePerPage;
    }

    public double getPricePerPage() {
        return pricePerPage;
    }
}
