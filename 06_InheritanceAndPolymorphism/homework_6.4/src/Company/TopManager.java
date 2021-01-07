package Company;

public class TopManager  implements Employee{

    private double salaryPercent = 1.5;
    private double incomeForBigSalary = 10000000;
    private Company company;

    @Override
    public void setCompany(Company company){
        this.company = company;
    }
    
    @Override
    public double getMonthSalary() {
        return company.getIncome() > incomeForBigSalary ? company.getFixSalary() + company.getFixSalary() * salaryPercent : company.getFixSalary();
    }

}
