public class Payment {

    //Тип счёта,Номер счета,Валюта,Дата операции,Референс проводки,Описание операции,Приход,Расход
    String paymentDescription;
    Double income;
    Double expense;

    Payment(String paymentDescription, Double income, Double expense){
        this.paymentDescription = paymentDescription;
        this.income = income;
        this.expense = expense;
    }

    @Override
    public String toString() {
        return "Payment {" +
                "paymentDescription='" + paymentDescription + '\'' +
                ", income=" + income +
                ", expense=" + expense +
                '}';
    }

    public String getPaymentDescription() {
        return paymentDescription;
    }

    public void setPaymentDescription(String paymentDescription) {
        this.paymentDescription = paymentDescription;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public Double getExpense() {
        return expense;
    }

    public void setExpense(Double expense) {
        this.expense = expense;
    }

}
