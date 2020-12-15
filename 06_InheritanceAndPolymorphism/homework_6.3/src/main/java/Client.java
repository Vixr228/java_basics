public abstract class Client {

    public double moneyAmount;
    public double getAmount() {
        return moneyAmount;
    }

    public void put(double amountToPut){
        if(amountToPut < 0) return;
        else moneyAmount += amountToPut;
    }

    public void take(double amountToTake){
        if(amountToTake > moneyAmount) return;
        else moneyAmount -= amountToTake;
    }

}
