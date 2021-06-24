package DataStructure.Exercises.MethodsExercises;


import java.util.Iterator;
import java.util.LinkedList;


public class QueueLinkedList {
    LinkedList<Integer> list = new LinkedList<>();
 
    int count =0;

    public void add(int value){
        list.addLast(value);
        count++;
    }

    public int remove(){
        if (this.isEmpty())
            throw new IllegalStateException();

        int item = list.indexOf(0);
        list.removeFirst();

        count--;
        return item;
    }

    public int peek(){
        if (count == 0)
            throw new IllegalStateException();

        int item = list.peek();
     
        return item;
    }

    public int size(){
        return list.size();
    }

    public boolean isEmpty(){
        return count==0;
    }


    @Override
    public String toString(){
        Iterator<Integer> listIt = list.iterator();
        String s="[";
        while(listIt.hasNext()){
            s = s + listIt.next() + ",";
        }
        s = s.substring(0, s.length() - 1);
        s= s + "]";
        return s;
    }
}
