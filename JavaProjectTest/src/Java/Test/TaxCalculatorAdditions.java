package Java.Test;

public interface TaxCalculatorAdditions {
    // This are addition to interfaces that might be a bad practice and should only be used with full consciousness of the user!! The program TaxCalculator.java
    // provides the interface without the additions. Remember, interfaces should be about what to do with the functions not how to do (e.g Classes). 
    
    float minimumTax = 100; // static field, cannot be changed. It might be better implement in classes not in interfaces
    
    static double getTaxableincome(double income , double expenses){
        return income - expenses;
    } //Might be a bad practice because the interface has implementation. Interfaces should be about what to do with functions not how to implement then. 
    

    double calculateTax();
}
