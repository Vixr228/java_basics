public class IndividualBusinessman extends Client {

    private double commissionPercentLess = 0.01;
    private double commissionPercentMore = 0.005;

    public IndividualBusinessman(){
        moneyAmount = 0;
    }

    @Override
    public void put(double amountToPut) {
        if(amountToPut < 0) return;
        if(amountToPut < 1000) moneyAmount += (amountToPut - amountToPut * commissionPercentLess);
        else moneyAmount += (amountToPut - amountToPut * commissionPercentMore);
    }

}
