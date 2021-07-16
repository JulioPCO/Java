package Projects.BankProject;

public class BankProjectMain {
    public static void main(String[] args){
        //String[] information = Console.console();
        //SQLImport.sqlImport(information[0], information[1]);
        SQLImport.sqlImport("ga@gmail.com", "BG4722");
        
        Account user_account = new Account();
        user_account.showBalance();
        //user_account.showAccountType();
        //user_account.showLoanRate();
        
        Transaction.deposit(user_account, 200);
        user_account.showBalance();

        Transaction.withdraw(user_account,300);
        user_account.showBalance();
        
        //SQLImport.sqlExport(information[0], information[1]);
    }
    
}
