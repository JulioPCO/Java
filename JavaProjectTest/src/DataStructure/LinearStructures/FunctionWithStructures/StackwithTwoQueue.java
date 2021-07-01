package DataStructure.LinearStructures.FunctionWithStructures;

import java.util.ArrayDeque;
import java.util.Queue;

public class StackwithTwoQueue {
    Queue<Integer> queue1 = new ArrayDeque<>();
    Queue<Integer> queue2 = new ArrayDeque<>();
    int count = 0;

    public void push(int value){
        queue1.add(value);
        count++;
    }

    public int pop(){
        if (isEmpty())
            throw new IllegalStateException();

        int item=0;
        int size = queue1.size();


        for(int i = 0; i< size; i++){
            if (i == size-1)
                item = queue1.remove();
            else
                queue2.add(queue1.remove());
        }
        
        while(!queue2.isEmpty())
            queue1.add(queue2.remove());
       
        count--;
        return item;
    }

    public int peek(){
        if (isEmpty())
            throw new IllegalStateException();

        int item=0;
        int size = queue1.size();


        for(int i = 0; i< size; i++){
            if (i == size-1)
                item = queue1.peek();
            
            queue2.add(queue1.remove());
        }
        
        while(!queue2.isEmpty())
            queue1.add(queue2.remove());

        return item;
    }

    public int size(){
        return count;
    }

    public boolean isEmpty(){
        return count == 0;
    }

    
}
