package com.company;

public class InsufficientPaperException extends Exception {
    private int maxNum;

    public InsufficientPaperException(int maxNum) {
        this.maxNum = maxNum;
    }

    @Override
    public String toString() {
        return "InsufficientPaperException{ The maximum capacity of the machine is: " + maxNum + " }";
    }
}
