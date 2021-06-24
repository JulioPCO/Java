package FunctionalInterfaces;

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class BynaryOperatorDemo {
    public static void show(){
        BinaryOperator<Integer> add = (a,b) -> a+b; 
        Function<Integer,Integer> square = a -> a*a;
        var result = add.andThen(square).apply(1, 2);
        System.out.println(result);

        UnaryOperator<Integer> square2 = n -> n*n;
        UnaryOperator<Integer> increment = n -> n++;

        increment.andThen(square2).apply(2);

    }
    
}
