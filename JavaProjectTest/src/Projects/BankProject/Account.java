package Projects.BankProject;

import java.util.ArrayList;

public class Account {
    private double balance;
    private String Account;
    private double rateLoan;
    private ArrayList<String> stringAarray = new ArrayList<>();

    public Account(){
        this.setInfo();
    }

    private ArrayList<String> accountBenefits(){
        if (balance < 1000){
            stringAarray.add("Standard");
            stringAarray.add("1.01");
            return stringAarray;
        }else if (balance < 10000){
            stringAarray.add("Special");
            stringAarray.add("1.015");
            return stringAarray;
        }else if (balance < 100000){
            stringAarray.add("Ultra");
            stringAarray.add("1.02");
            return stringAarray;
        }else{
            stringAarray.add("Standard");
            stringAarray.add("1.03");
            return stringAarray;
        }

    }

    public void showAccountType(){
        System.out.println(Account);
    }

    public void showBalance(){
        System.out.print("Balance: ");
        System.out.println(balance);
    }

    public void showLoanRate(){
        System.out.println(rateLoan);
    }


    public void setBalance(){
        this.balance = Balance.getBalance();
    }

    public void setInfo(){
        this.setBalance();
        var infoArray = accountBenefits();
        this.Account = infoArray.get(0);
        this.rateLoan = Double.parseDouble(infoArray.get(1));
    }
}
