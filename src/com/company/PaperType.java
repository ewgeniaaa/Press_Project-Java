package com.company;

public enum PaperType {
    STANDARD(0.), GLAZED(1.), NEWSPAPER(0.5);

    private double pricePerType;

    PaperType(double pricePerType) {
        this.pricePerType = pricePerType;
    }

    public void setPricePerType(double pricePerType) {
        this.pricePerType = pricePerType;
    }

    public double getPricePerType() {
        return pricePerType;
    }
}
