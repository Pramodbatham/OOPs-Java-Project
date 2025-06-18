package Employee_Payroll;

import java.util.ArrayList;

abstract class Employee{
    private String name;
    private int id;

    public Employee(String name, int id){
        this.name = name;
        this.id = id;
    }

    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }

    public abstract double calculateSalary();

    @Override
    public String toString(){
        return " Employee [Name : "+name+" , Id : "+id+" , Salary : "+calculateSalary()+"]";
    }
}

class fullTimeEmployee extends Employee{
    private double monthlySelary;

    public fullTimeEmployee(String name, int id, double monthlySelary){
        super(name,id);
        this.monthlySelary = monthlySelary;
    }

    @Override
    public double calculateSalary(){
        return monthlySelary;
    }
}

class PartTimeEmployee extends Employee{
    private int hoursWorked;
    private double hourslyRate;

    public PartTimeEmployee(String name, int id, int hoursWorked, double hourslyRate){
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hourslyRate = hourslyRate;
    }

    @Override
    public double calculateSalary(){
        return hoursWorked * hourslyRate;
    }
}

class Payroll{
    private ArrayList<Employee> employeeList;

    public Payroll(){
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }

    public void removeEmployee(int id){
        Employee employeeToRemove = null;

        for(Employee employee : employeeList){
            if(employee.getId() == id){
                employeeToRemove = employee;
                break;
            }
        }
        if(employeeToRemove != null){
            employeeList.remove(employeeToRemove);
        }
    }

    public void display(){
        for(Employee employee: employeeList){
            System.out.println(employee);
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Payroll payroll = new Payroll();
        fullTimeEmployee emp1 = new fullTimeEmployee("Ronit",1,80000.0);
        PartTimeEmployee emp2 = new PartTimeEmployee("Vibhor",2,50,100);
        payroll.addEmployee(emp1);
        payroll.addEmployee(emp2);
        payroll.display();
    }
}
