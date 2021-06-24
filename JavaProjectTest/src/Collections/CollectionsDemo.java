package Collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CollectionsDemo {
    public static void show(){
        Collection<String> collection = new ArrayList<>();
        Collections.addAll(collection, "a","b","c");
        for(var item: collection)
            System.out.println(item);
        
        System.out.println(collection.size());
        collection.remove("b");
        System.out.println(collection);

        var objectArray = collection.toArray();
        var stringArray = collection.toArray(new String[0]);

        Collection<String> other = new ArrayList<>();
        other.addAll(collection);

        System.out.println(collection.equals(other));
    }
}
