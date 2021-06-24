package ExampleAdvanced;

import java.io.IOException;

import Exceptions.Account;
import Exceptions.AccountException;
import Exceptions.ExceptionsDemo;
import Exceptions.InsufficientFundException;

public class MainExceptions {
    public static void main(String[] args) throws IOException{
        ExceptionsDemo.showUncheckedException();

        var acc = new Account();
        acc.deposit(-1);
        try {
            acc.depositIO(-1);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("Logging");
            throw e;
        } 

        try {
            acc.withdraw(10);
        } catch (AccountException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

}
