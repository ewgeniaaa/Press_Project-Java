package com.company;

public class ThreeForArray {
    private Edition edition;
    private PaperType paperType;
    private int numberOfCopies;

    public ThreeForArray(Edition edition, PaperType paperType, int numberOfCopies) {
        this.edition = edition;
        this.paperType = paperType;
        this.numberOfCopies = numberOfCopies;
    }

    public Edition getEdition() {
        return edition;
    }

    public PaperType getPaperType() {
        return paperType;
    }

    public int getNumberOfCopies() {
        return numberOfCopies;
    }
}
