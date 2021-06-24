package FunctionalInterfaces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {

    public static void show(){
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list,1,2,3);

        //Declarative progaming
        list.forEach((Integer item) -> {System.out.println(item);});

        List<String> listStr = List.of("a","b","c");
        
        Consumer<String> print = (String item) -> {System.out.println(item);};
        Consumer<String> printUpperCase =  item -> System.out.println(item.toUpperCase());

        listStr.forEach(print.andThen(printUpperCase).andThen(print));
    }


        
}
