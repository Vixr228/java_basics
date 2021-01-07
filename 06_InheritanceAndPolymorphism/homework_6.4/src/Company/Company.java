package Company;

import java.util.*;

public class Company{

    private long income = 5000000 + (long)(Math.random() * 12000000);
    private int fixSalary = 50000;
    private ArrayList<Employee> employeeList;

    public Company(){
        employeeList = new ArrayList<>();

    }

    public ArrayList<Employee> getTopSalaryStaff(int count){
        if(count > 0 && count < employeeList.size()) {
            Collections.sort(employeeList, new EmployeeComparator());
            ArrayList<Employee> topArray = new ArrayList<Employee>();
            for (int i = 0; i < count; i++) {
                topArray.add(employeeList.get(i));
            }
            return topArray;
        }
        else return new ArrayList<Employee>();
    }

    public ArrayList<Employee> getLowesSalaryStaff(int count){
        if(count > 0 && count < employeeList.size()) {
            Collections.sort(employeeList, new EmployeeComparator());
            ArrayList<Employee> LowestArray = new ArrayList<Employee>();
            for (int i = employeeList.size() - 1; i > employeeList.size() - count - 1; i--) {
                LowestArray.add(employeeList.get(i));
            }
            return LowestArray;
        }
        else return new ArrayList<Employee>();
    }
    public void hire(Employee employee){
        employee.setCompany(this);
        employeeList.add(employee);
    }

    public void hireAll(ArrayList<Employee> hireAllEmployee){
        for(Employee emp : hireAllEmployee){
            emp.setCompany(this);
        }
        employeeList.addAll(hireAllEmployee);
    }

    public void fireByCount(int count){
        if(count > 0 && count < employeeList.size()) {
            for (int i = 0; i < count; i++) {
                employeeList.remove(i);
            }
        }
        else System.out.println("Error");
    }

    public void fireByIndex(int index){
        if(index > 0 && index < employeeList.size())
            employeeList.remove(index);
        else System.out.println("Error");
    }

    public long getIncome(){
        return this.income;
    }

    public void setIncome(long income) {
        this.income = income;
    }

    public int getEmployeeAmount(){
        return employeeList.size();
    }

    public void getAllEmployee(){
        for(Employee emp : employeeList){
            System.out.println(emp.getMonthSalary());
        }
    }

    public int getFixSalary() {
        return fixSalary;
    }

    public void setFixSalary(int fixSalary) {
        this.fixSalary = fixSalary;
    }



}
