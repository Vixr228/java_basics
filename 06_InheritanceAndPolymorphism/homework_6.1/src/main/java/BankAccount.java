public class BankAccount {
    private double moneyAmount;

    public BankAccount() {
        moneyAmount = 0;
    }

    public double getAmount() {
        return moneyAmount;
    }

    public void put(double amountToPut) {
        if (amountToPut < 0) return;
        else moneyAmount += amountToPut;
    }

    public void take(double amountToTake) {
        if (amountToTake > moneyAmount) return;
        else moneyAmount -= amountToTake;
    }

    public double getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(double moneyAmount) {
        this.moneyAmount = moneyAmount;
    }
}
