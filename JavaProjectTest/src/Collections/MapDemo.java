package Collections;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    public static void show(){
        //Java maps
        //python dictionaries 
        //C# dictionaries
        //Javascript: Objects

        var c1 = new Customer("a", "e3");
        var c2 = new Customer("b", "e2");
        var c3 = new Customer("c", "e1");
        Map<String,Customer> map = new HashMap<>();

        map.put(c1.getEmail(), c1);
        map.put(c2.getEmail(), c2);
        map.put(c3.getEmail(), c3);

        var customer = map.get("e1");
        System.out.println(customer);

        var customer2 = map.get("e10"); // Doesn't exist on list --> null
        System.out.println(customer2);

        var unknownCustomer = new Customer("Unknown","");
        var customer3 = map.getOrDefault("e10", unknownCustomer);
        System.out.println(customer3);

        var exist = map.containsKey("e10");
        System.out.println(exist);

        map.replace("e1", new Customer("c++","e1"));
        System.out.println(map);

        for (var key: map.keySet())
            System.out.println(key);
        
        for (var value: map.values())
            System.out.println(value);

        for (var entry: map.entrySet())
            System.out.println(entry);

    }
}
