public class CardAccount extends BankAccount {

    public double commissionPercent = 0.01;

    @Override
    public void take(double amountToTake) {
        if(amountToTake > moneyAmount) return;
        else moneyAmount -= amountToTake + (amountToTake * commissionPercent);
    }
}
