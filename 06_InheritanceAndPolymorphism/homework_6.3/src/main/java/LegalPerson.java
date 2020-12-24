public class LegalPerson extends Client {

    private double commissionPercent = 0.01;

    @Override
    public void take(double amountToTake) {
        if(amountToTake > getMoneyAmount()) return;
        else setMoneyAmount(getMoneyAmount() - (amountToTake + (amountToTake * commissionPercent)));
    }

    @Override
    public void info() {
        System.out.println("Информация о счете:");
        System.out.println("Текущий баланс: " + super.getAmount());
        System.out.println("Условия снятия: комиссия 1%.");
        System.out.println("Условия пополнения: без комиссии.");
    }
}
