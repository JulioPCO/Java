package FunctionalInterfaces;

import java.util.function.Supplier;

public class SupplierDemo {
    
    public static void show(){
        Supplier<Double> getRandom = () -> {return Math.random();}; 
        var random = getRandom.get();
        System.out.println(random);


    }
}
