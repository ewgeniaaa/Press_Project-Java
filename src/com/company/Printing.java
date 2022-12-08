package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Printing {
    private List<Machine> machineList;
    private List<ThreeForArray> forPrintList;
    private List<ThreeForArray> finishedPrintingList;
    private double paperExpenses;
    private int quantityForDiscount;
    private double percentDiscount;

    public Printing( int quantityForDiscount, double percentDiscount) {
        this.machineList = new ArrayList<>();
        this.forPrintList = new ArrayList<>();
        this.finishedPrintingList = new ArrayList<>();
        this.quantityForDiscount = quantityForDiscount;
        this.percentDiscount = percentDiscount;
        this.paperExpenses = 0;
    }

    public void addMachine(Machine machine){
        this.machineList.add(machine);
    }

    public void addEdition(Edition edition, PaperType paperType, int numberOfCopies){
        ThreeForArray threeForArray = new ThreeForArray(edition, paperType, numberOfCopies);
        this.forPrintList.add(threeForArray);
    }

    public void startPrinting(){
        for (Machine machine:machineList) {
            Thread thread = new Thread(new MachineThread(this, machine));
            thread.start();
        }
    }

    public void addPrintedEdition(ThreeForArray threeForArray){
        this.finishedPrintingList.add(threeForArray);
    }

    public boolean isThereMoreForPrint(){
        return this.forPrintList.size() > 0;
    }

    public synchronized ThreeForArray takeEdition(){
        ThreeForArray tmp = this.forPrintList.get(this.forPrintList.size() - 1);
        this.forPrintList.remove(tmp);
        this.addPrintedEdition(tmp);
        return tmp;
    }

    public void printing(Machine machine){
        while (isThereMoreForPrint() && machine.getPaperQuantity() > 0){
            ThreeForArray current = takeEdition();
            Paper paper = new Paper(current.getEdition().getPageSize(), current.getPaperType());
            this.addPaperExpenses(paper.getPricePerList()*current.getEdition().getNumberOfPages()*current.getNumberOfCopies());
            if (machine.getPaperQuantity() >= current.getEdition().getNumberOfPages()) {
                FileWriter fout = null;
                try {
                    fout = new FileWriter(new File(machine.getModel()+".txt"), true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                for (int i = 1; i <= current.getNumberOfCopies(); i++) {
                    System.out.println(machine.getModel() + " printing " + current.getEdition().getTitle() + " copy " + i);
                    try {
                        fout.append(machine.getModel() + " printing " + current.getEdition().getTitle() + " copy " + i + System.lineSeparator());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    machine.removePaper(current.getEdition().getNumberOfPages());
                }
                try {
                    if (fout != null) {
                        fout.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else{
                try {
                    throw new InsufficientPaperException(machine.getMaxPaperQuantity());
                } catch (InsufficientPaperException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public void addPaperExpenses(double paperExpenses) {
        this.paperExpenses += paperExpenses;
    }

    public double getPaperExpenses() {
        return this.paperExpenses;
    }

    public int getQuantityForDiscount() {
        return quantityForDiscount;
    }

    public double getPercentDiscount() {
        return percentDiscount;
    }

    public List<ThreeForArray> getFinishedPrintingList() {
        return finishedPrintingList;
    }
}
