package Projects.Mortgage;

public class MortgageCalculatorClass {
    private int principal;
    private float AIR;
    private byte year;

    private int periodMonths;
    private float percentAIR;

    final static byte months = 12;
    final static byte percent = 100;

    public MortgageCalculatorClass(){
        this.set();
        periodMonths = year*months;
        percentAIR = AIR/(percent*months);
    }

    private void set() {
        principal = (int)Console.readNumber("Principal: ", 100000, 1000000); 
        AIR = (float)Console.readNumber("Annual Interest rate: ", 0, 30); 
        year = (byte)Console.readNumber("Period (Years):", 0, 30);       
    }

    public double calculateMortgage(){
        return principal * (percentAIR*Math.pow((1+percentAIR), periodMonths))/(Math.pow((1+percentAIR), periodMonths) - 1);                                             
    }

    public double calculatePayment(int numberOfPayments){
        double toPay = principal * (Math.pow((1+percentAIR), periodMonths) - Math.pow((1+percentAIR), numberOfPayments))/(Math.pow((1+percentAIR), periodMonths) - 1); 
        return toPay;
    }

    public double[] paymentSchedule(){
        double[] payments = new double[periodMonths];
        for(int i=1; i<periodMonths; i++){
            payments[i-1] = calculatePayment(i);         
        }
        return payments;
    }

    public void getInputParameters() {
        System.out.println("Principal: " + principal);
        System.out.println("Annual Interest rate: " + AIR);
        System.out.println("Period (Years): " + year);
    }
}
