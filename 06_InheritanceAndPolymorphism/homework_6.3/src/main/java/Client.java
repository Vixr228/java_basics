public abstract class Client {


    private double moneyAmount = 0;

    public double getAmount() {
        return this.moneyAmount;
    }

    public void put(double amountToPut){
        if(amountToPut > 0)
            this.moneyAmount += amountToPut;
    }

    public void take(double amountToTake){
        if(amountToTake <= moneyAmount)
            this.moneyAmount -= amountToTake;
    }

    public double getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(double moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public abstract void info();

}
