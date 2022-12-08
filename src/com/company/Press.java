package com.company;

import java.util.ArrayList;
import java.util.List;

public class Press {
    private double mainSalary;
    private double incomeNeededForBonus;
    private double percentBonusManager;
    private List<Employee> employeeList;
    private Printing printing;

    public Press(double mainSalary, double incomeNeededForBonus, double percentBonusManager, Printing printing) {
        this.mainSalary = mainSalary;
        this.incomeNeededForBonus = incomeNeededForBonus;
        this.percentBonusManager = percentBonusManager;
        this.printing = printing;
        this.employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        this.employeeList.add(employee);
    }

    public double employeeExpenses(){
        double sum = 0;
        if (this.calculateIncome() >= incomeNeededForBonus){
            for (Employee employee:employeeList) {
                sum += this.mainSalary;
                if (employee.getEmployeeType() == EmployeeType.valueOf("MANAGER"))
                    sum += this.mainSalary*percentBonusManager;
            }
        }
        else {
            sum += this.mainSalary*employeeList.size();
        }
        return sum;
    }


    public double calculateExpenses(){
        return this.employeeExpenses()+printing.getPaperExpenses();
    }

    public double calculateIncome(){
        double sum = 0;
        for (ThreeForArray threeForArray:printing.getFinishedPrintingList()) {
            Edition edition = threeForArray.getEdition();
            if (printing.getQuantityForDiscount() <= threeForArray.getNumberOfCopies()){
                sum += edition.getSellingPrice()*(1. - printing.getPercentDiscount())*threeForArray.getNumberOfCopies();
            }
            else{
                sum += edition.getSellingPrice()*threeForArray.getNumberOfCopies();
            }
        }
        return sum;
    }

    public Printing getPrinting() {
        return printing;
    }
}
