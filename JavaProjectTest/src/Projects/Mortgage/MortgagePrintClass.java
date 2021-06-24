package Projects.Mortgage;

import java.text.NumberFormat;

public class MortgagePrintClass {
    private static MortgageCalculatorClass mortgagecalculator = new MortgageCalculatorClass();
    private NumberFormat mortgageCurrencyObj= NumberFormat.getCurrencyInstance();

    public void printMortgage(){
        String prompt = "Mortgage";
        System.out.println(prompt);
        System.out.println("-".repeat(prompt.length()));

        System.out.println("Monthly payment: " + mortgageCurrencyObj.format(mortgagecalculator.calculateMortgage()));
        
    }

    public void printPaymentSchedule(){
        String prompt = "Payment Schedule";
        System.out.println("Payment Schedule");
        System.out.println("-".repeat(prompt.length()));

        for(double balance:mortgagecalculator.paymentSchedule())
        System.out.println("To pay monthly: " + mortgageCurrencyObj.format(balance)); 

    }
    
}
