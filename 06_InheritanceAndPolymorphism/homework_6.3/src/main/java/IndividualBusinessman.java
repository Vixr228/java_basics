public class IndividualBusinessman extends Client {

    private double commissionPercentLess = 0.01;
    private double commissionPercentMore = 0.005;

    public IndividualBusinessman(){
        setMoneyAmount(0);
    }

    @Override
    public void put(double amountToPut) {
        if(amountToPut < 0) return;
        if(amountToPut < 1000) setMoneyAmount(getMoneyAmount() + (amountToPut - amountToPut * commissionPercentLess));
        else setMoneyAmount(getMoneyAmount() + (amountToPut - amountToPut * commissionPercentMore));
    }

    @Override
    public void info() {
        System.out.println("Информация о счете:");
        System.out.println("Текущий баланс: " + super.getAmount());
        System.out.println("Условия снятия: комиссия 1%.");
        System.out.println("Условия пополнения: \nКомиссия 1%, если сумма пополнения меньше 1000 рублей.\n" +
                "Комиссия 0.5%, если сумма пополнения больше или равна 1000 рублей.");
    }

}
