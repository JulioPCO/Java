package ExampleAdvanced;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Collections.CollectionsDemo;
import Collections.Customer;
import Collections.EmailComparator;
import Collections.ListDemo;
import Collections.MapDemo;
import Collections.QueueDemo;
import Collections.SetDemo;

public class MainCollections {
    public static void main(String[] args){
        CollectionsDemo.show();
        ListDemo.show();

        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("b","e3"));
        customers.add(new Customer("a","e5"));
        customers.add(new Customer("c","e1"));
        Collections.sort(customers);
        System.out.println(customers);
        Collections.sort(customers, new EmailComparator());
        System.out.println(customers);

        QueueDemo.show();
        SetDemo.show();
        MapDemo.show();
    }
}
