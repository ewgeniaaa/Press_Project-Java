package com.company;

public class Machine {
    private String model;
    private int maxPaperQuantity;
    private int paperQuantity;
    private boolean printColor;

    public Machine(String model, int maxPaperQuantity, int paperQuantity, boolean printColor) {
        this.model = model;
        this.maxPaperQuantity = maxPaperQuantity;
        this.paperQuantity = paperQuantity;
        this.printColor = printColor;
    }

    public String getModel() {
        return model;
    }

    public int getMaxPaperQuantity() {
        return maxPaperQuantity;
    }

    public int getPaperQuantity() {
        return paperQuantity;
    }

    public void addPaper(int paperQuantity) {
        if(this.paperQuantity+paperQuantity <= maxPaperQuantity)
            this.paperQuantity += paperQuantity;
        else
            System.out.println("The max capacity of the printer is " + maxPaperQuantity);
    }

    public void removePaper(int paperQuantity) {
        if(this.paperQuantity - paperQuantity >= 0)
            this.paperQuantity -= paperQuantity;
        else
            System.out.println("The machine has only " + this.paperQuantity);
    }
}
