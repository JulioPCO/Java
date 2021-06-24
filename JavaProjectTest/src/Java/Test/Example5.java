package Java.Test;

public class Example5 {
    public static void main(String[] args){
        int taxableIncome = 100000;
        var calculator = new TaxCalculator2018(taxableIncome);
        var report = new TaxReport(calculator);

        report.show();

        report.setCalculator(new TaxCalculator2019(taxableIncome));
        report.show();

        report.show(calculator);

    }
}
