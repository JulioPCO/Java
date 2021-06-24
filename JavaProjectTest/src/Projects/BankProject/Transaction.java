package Projects.BankProject;

public class Transaction {
    
    public static void deposit(Account user, double amount){
        Balance.setBalance(amount);
        user.setInfo();
    }

    public static void withdraw(Account user, double amount){
        Balance.setBalance(-amount);
        user.setInfo();
    }

}
