import Company.Company;
import Company.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Creating company...");
        Company myCompany = new Company();
        System.out.println("Company income: " + myCompany.getIncome());

        for (int i = 0; i < 180; i++) {
            if(i < 10) myCompany.hire(new TopManager());
            if(i < 80) myCompany.hire(new Manager());
            myCompany.hire(new Operator());
        }
        System.out.println("MyCompany amount: " + myCompany.getEmployeeAmount());

        ArrayList<Employee> topSalary = new ArrayList<>();
        topSalary = myCompany.getTopSalaryStaff(15);
        System.out.println("Top 15 salaries of our company: ");
        printArray(topSalary);

        ArrayList<Employee> lowestSalary = new ArrayList<>();
        lowestSalary = myCompany.getLowesSalaryStaff(30);
        System.out.println("The 30 lowest salaries of our company: ");
        printArray(lowestSalary);


        System.out.println("Let's fire somebody...");
        int companySize = myCompany.getEmployeeAmount();
        for (int i = 0; i < companySize / 2; i++) {
            int index = (int) (Math.random() * myCompany.getEmployeeAmount());
            myCompany.fireByIndex(index);
        }
        //myCompany.getAllEmployee();
        System.out.println("MyCompany amount: " + myCompany.getEmployeeAmount());


        topSalary = myCompany.getTopSalaryStaff(15);
        System.out.println("Top 15 salaries of our company after fire: ");
        printArray(topSalary);
        lowestSalary = myCompany.getLowesSalaryStaff(30);
        System.out.println("The 30 lowest salaries of our company after fire: ");
        printArray(lowestSalary);

    }

    public static void printArray(ArrayList<Employee> salary){
        int count = 1;
        for(Employee emp : salary){
            System.out.println(count++ + " " + emp.getMonthSalary());
        }
    }
}
