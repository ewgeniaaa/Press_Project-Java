package com.company;

public class MachineThread implements Runnable{
    private Printing printing;
    private Machine machine;

    public MachineThread(Printing printing, Machine machine) {
        this.printing = printing;
        this.machine = machine;
    }

    @Override
    public void run() {
        printing.printing(machine);
    }
}
