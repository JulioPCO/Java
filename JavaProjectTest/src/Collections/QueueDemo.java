package Collections;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueDemo {
    public static void show(){
        Queue<String> queue = new ArrayDeque<>(); 
        queue.add("c");
        queue.add("a");
        queue.add("b");
        //queue.offer("d"); //same as add but less agressive ( returns false instead of exception)

        var front = queue.peek(); // queue.element() is the same but if the queue is empty throws an exception
        System.out.println(front);

        var frontRemove = queue.poll();//queue.remove same but throws exception
        System.out.println(frontRemove);
        System.out.println(queue);
    }
    
}
