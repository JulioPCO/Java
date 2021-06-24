package Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SetDemo { // no duplicates, but do not rely on the order
    public static void show(){
        Set<String> set = new HashSet<>();
        set.add("sky");
        set.add("is");
        set.add("blue");
        set.add("blue");

        System.out.println(set);

        Collection<String> collection = new ArrayList<>();
        Collections.addAll(collection,"a", "b", "c", "c");
        Set<String> setTransformCollection = new HashSet<>(collection);
        System.out.println(setTransformCollection);

        Set<String> setArray1 = new HashSet<>(Arrays.asList("a","b","c"));
        Set<String> setArray2 = new HashSet<>(Arrays.asList("b","c","d"));

        //Union
        setArray1.addAll(setArray2);
        System.out.println(setArray1);

        //Intersection
        setArray1.retainAll(setArray2);
        System.out.println(setArray1);

        //Difference
        setArray1.removeAll(setArray2);
        System.out.println(setArray1);
    }
}
