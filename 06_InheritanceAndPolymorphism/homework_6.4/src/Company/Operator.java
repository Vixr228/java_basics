package Company;

public class Operator implements Employee {

    private Company company;
    @Override
    public void setCompany(Company company){
        this.company = company;
    }

       @Override
    public double getMonthSalary() {
        return company.getFixSalary();
    }
}
