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

    }

}
