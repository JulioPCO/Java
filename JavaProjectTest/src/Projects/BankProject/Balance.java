package Projects.BankProject;

public class Balance {
    private static double balance;
    
    public static double getBalance(){
        return balance;
    }

    public static void setBalance(double amount){
        if (balance + amount < 0){
            System.out.println("Not sufficient funds");
        }else{
            balance =  balance + amount;
        }    
    }

}
