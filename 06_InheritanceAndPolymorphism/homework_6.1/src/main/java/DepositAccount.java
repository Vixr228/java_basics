import java.util.Calendar;

public class DepositAccount extends BankAccount {
    private Calendar lastIncome;

    DepositAccount(){
        lastIncome = Calendar.getInstance();
    }

    @Override
    public void put(double amountToPut) {
        lastIncome = Calendar.getInstance();
        if(amountToPut < 0) return;
        else moneyAmount += amountToPut;
    }

    @Override
    public void take(double amountToTake) {
        Calendar currTime = Calendar.getInstance();
        lastIncome.roll(Calendar.MONTH, 1);
        if(amountToTake <= moneyAmount && currTime.getTime().after(lastIncome.getTime())) moneyAmount -= amountToTake;
        else return;
    }
}
