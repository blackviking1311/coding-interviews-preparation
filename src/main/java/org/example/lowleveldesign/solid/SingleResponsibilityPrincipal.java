package org.example.lowleveldesign.solid;

class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

interface Calculator {
    double calculate(double amount);
}

class TaxCalculator implements Calculator {
    @Override
    public double calculate(double amount) {
        return amount * 0.20;
    }
}

public class SingleResponsibilityPrincipal {

    public static void main(String[] args) {
        Employee employee = new Employee("Ankit", 113998.30);
        Calculator calculator = new TaxCalculator();
        System.out.println(calculator.calculate(employee.getSalary()));
    }
}
