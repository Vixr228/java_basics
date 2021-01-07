package Company;

public class Manager implements Employee{
    private double salaryPercent = 0.05;
    private int earnedMoney = 0;
    private Company company;

    public Manager(){
        earnedMoney =  115000 + (int) (Math.random() * 140000);
    }

    @Override
    public void setCompany(Company company){
        this.company = company;
    }

    @Override
    public double getMonthSalary() {
        return company.getFixSalary() + (earnedMoney * salaryPercent);
    }
}
