package ExampleAdvanced;

import Generics.GenericList;
import Generics.GenericListIterable;
import Generics.Instructor;
import Generics.List;
import Generics.User;
import Generics.Utils;

public class MainGenerics {
    public static void main(String[] args){
        var list = new List();
        var user1 = new User(10);
        list.add(1);

        var listgeneric = new GenericList<Integer>(); //Accepts references types(String, Object, Integer,Float, Boolean), but no types(int,float, boolean)
        listgeneric.add(1); // Boxing 1-> put the value inside of a instance of integer class
        listgeneric.get(0); //Unboxing

        System.out.println(user1.compareTo(new User(20)));

        Utils.max(10, 2);
        System.out.println(Utils.max(new User(10),new User(20)));

        Utils.print(10, 12.0);

        User user2 = new Instructor(10);
        Utils.printUsers(user2);

        var users = new GenericList<User>();
        Utils.printUsers(users);

        Utils.printUsers(user2);

        var abc = new GenericListIterable<String>();
        var iterator = abc.iterator();
        abc.add("a");
        abc.add("b");
        abc.add("c");
        while (iterator.hasNext()){
            var current = iterator.next();
            System.out.println(current);
        }
    }
}
