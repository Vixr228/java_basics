public class CardAccount extends BankAccount {

    private double commissionPercent = 0.01;

    @Override
    public void take(double amountToTake) {
        if(amountToTake > getMoneyAmount()) return;
        else setMoneyAmount(getMoneyAmount() - (amountToTake + amountToTake * commissionPercent));
    }
}
