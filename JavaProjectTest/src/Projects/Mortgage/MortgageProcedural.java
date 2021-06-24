package Projects.Mortgage;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageProcedural{

    final static byte months = 12;
    final static byte percent = 100;
    public static void main(String[] args){        
        int principal =  (int)readNumber("Principal: ", 1_000, 1_000_000);
        float AIR = (float)readNumber("Annual Interest Rate:", 1, 30);
        byte periodYears = (byte)readNumber("Period (Years):", 0, 30);

        double mortgage = calculateMortgage(principal, AIR, periodYears);       
        printmortgage("Mortgage", "Monthly payment: ", mortgage, principal, AIR, periodYears, true);
        printmortgage("Payment", "To pay: ",  mortgage, principal, AIR, periodYears, false);

    }

    public static void printmortgage(String prompt, String promptOutput,double mortgage, int principal,float AIR,byte periodYears, boolean flagPayment){
        System.out.println(prompt);
        System.out.println("-".repeat(prompt.length()));

        if (flagPayment == true){
            NumberFormat mortgageCurrencyObj = NumberFormat.getCurrencyInstance() ;  
            System.out.println(promptOutput + mortgageCurrencyObj.format(mortgage));
        }
        else{
            int numberOfPayments = 1;
            double payments = 1;

            while(payments > 0){
                NumberFormat mortgageCurrencyObj = NumberFormat.getCurrencyInstance() ;  
                payments = paymentschedule(principal, AIR, periodYears,numberOfPayments);
                System.out.println(promptOutput + mortgageCurrencyObj.format(payments));
                numberOfPayments++;
            }
        }
        
    }

    public static double paymentschedule(int principal,float AIR,byte periodYears, int numberofpayments ){
        int periodMonths = periodYears*months;
        AIR = AIR/(percent*months);
        
        int payments = numberofpayments;
        double toPay = principal * (Math.pow((1+AIR), periodMonths) - Math.pow((1+AIR), payments))/(Math.pow((1+AIR), periodMonths) - 1); 
        return toPay;
    }

    public static double readNumber(String prompt, double min, double max){
        System.out.print(prompt);
        Scanner scanner = new Scanner(System.in);
        double value = scanner.nextInt();
        while (value < min || value >max){
            System.out.println("Enter a number between:" + min + "and" + max);
            System.out.print(prompt);
            value = scanner.nextInt();
            }

        return value;
    }

    public static double calculateMortgage(
        int principal,
        float AIR, 
        byte periodYears){

            int periodMonths = periodYears*months;
            AIR = AIR/(percent*months);
            double mortgage = principal * (AIR*Math.pow((1+AIR), periodMonths))/(Math.pow((1+AIR), periodMonths) - 1);
            return  mortgage;                                
    
    }

}

