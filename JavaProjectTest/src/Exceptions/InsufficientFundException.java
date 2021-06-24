package Exceptions;

// Checked --> Exception
// Unchecked(runtime) --> RuntimeException
public class InsufficientFundException extends Exception{
    public InsufficientFundException(){
        super("Insufficient fund");
    }
    public InsufficientFundException(String message){
        super(message);
    }
}
