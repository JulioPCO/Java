package Java.Test;

public class TaxReport {
    private TaxCalculator calculator;

    public TaxReport(TaxCalculator calculator){
        this.calculator = calculator; // constructor injection
    }

    //or

    public void setCalculator(TaxCalculator calculator){
        this.calculator = calculator; // setter injection
    }

    //or

    public void show(TaxCalculator calculator){
        var tax = calculator.calculateTax();
        System.out.println(tax); // method injector
    }


    public void show(){
        var tax = calculator.calculateTax();
        System.out.println(tax);
    }
}
