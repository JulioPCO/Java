package Java.Test;

public class TaxCalculator2018 implements TaxCalculator {
    private double taxableIncome;

    public TaxCalculator2018(double taxableIncome){
        this.taxableIncome = taxableIncome;
    }

    @Override // best practice when working with interfaces
    public double calculateTax(){
        return taxableIncome *0.3;
    }
}
