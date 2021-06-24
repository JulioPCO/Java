package Exceptions;

import java.io.IOException;

public class Account {
    private float balance;

    public void deposit(float value){
        if (value <= 0)
            throw new IllegalArgumentException(); // throwing exceptions
    }

    public void depositIO(float value) throws IOException{
        if (value <= 0)
            throw new IOException(); // throwing exceptions
    }

    //Custom exceptions
    public void withdraw(float value) throws AccountException{
        if (value > balance)
            throw new AccountException(new InsufficientFundException()); // chained exception
        
    }
}
