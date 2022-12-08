package com.company;

public class Main {

    public static void main(String[] args) {
        // Creating Editions
        Edition edition1 = new Edition("Book1", EditionType.BOOK, 30, PageSize.A5, 7.);
        Edition edition2 = new Edition("Book2", EditionType.BOOK, 50, PageSize.A4, 15.);
        Edition edition3 = new Edition("Poster1", EditionType.POSTER, 20, PageSize.A3, 6.);
        Edition edition4 = new Edition("Newspaper1", EditionType.NEWSPAPER, 15, PageSize.A2, 4.);
        Edition edition5 = new Edition("Newspaper2", EditionType.NEWSPAPER, 10, PageSize.A1, 5.);

        // Creating Machines
        Machine machine1 = new Machine("Machine1", 1000000, 0, true);
        Machine machine2 = new Machine("Machine2", 1500000, 0, false);
        Machine machine3 = new Machine("Machine3", 2000000, 0, true);

        //Adding paper to the machines
        machine1.addPaper(10000);
        machine2.addPaper(15000);
        machine3.addPaper(20000);

        //Creating Employees
        Employee employee1 = new Employee("Employee1", EmployeeType.MANAGER);
        Employee employee2 = new Employee("Employee2", EmployeeType.MANAGER);
        Employee employee3 = new Employee("Employee3", EmployeeType.OPERATOR);
        Employee employee4 = new Employee("Employee4", EmployeeType.OPERATOR);
        Employee employee5 = new Employee("Employee5", EmployeeType.OPERATOR);

        // Creating the Press
        Press press = new Press(1000, 500, 0.15, new Printing(40, 0.1));

        
        press.getPrinting().addMachine(machine1);
        press.getPrinting().addMachine(machine2);
        press.getPrinting().addMachine(machine3);

        press.addEmployee(employee1);
        press.addEmployee(employee2);
        press.addEmployee(employee3);
        press.addEmployee(employee4);
        press.addEmployee(employee5);

        press.getPrinting().addEdition(edition1, PaperType.STANDARD,20);
        press.getPrinting().addEdition(edition2, PaperType.STANDARD,30);
        press.getPrinting().addEdition(edition3, PaperType.GLAZED,25);
        press.getPrinting().addEdition(edition4, PaperType.NEWSPAPER,10);
        press.getPrinting().addEdition(edition5, PaperType.NEWSPAPER,50);

        press.getPrinting().startPrinting();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Expenses: " + press.calculateExpenses());
        System.out.println("Income: " + press.calculateIncome());
    }
}
