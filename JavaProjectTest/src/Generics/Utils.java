package Generics;

public class Utils {
    public static <T extends Comparable<T> > T max(T first, T second){
        return (first.compareTo(second) < 0) ? second:first;
    }

    public static <K , V> void print(K key, V value){
        System.out.println(key + "=" + value);
    }

    public static void printUsers(User user){
        System.out.println(user);
    }

/*     public static void printUsers(GenericList<User> user){ // using instructor causes exception
        System.out.println(user);
    } */

    public static void printUsers(GenericList<? extends User> user){ // ? extends --> Object x = user.get(0); --> allow reading
        System.out.println(user);                                    // ? super --> GenericList<Object> = new GenericList(); --> allow add
    }
}
