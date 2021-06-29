package DataStructure.LinearStructures;

import java.util.Arrays;

public class Queue {
    private int[] values;
    private int first = 0;
    private int last = 0;
    private int counter = 0;

    public Queue(int length){
        values = new int[length];
    }

    public void add(int value){
        if (counter == values.length)
            throw new IllegalStateException();
                
        values[last++] = value;

        if (last == values.length) // or last = (last+1)%5
            last = 0;

        counter++;
    }

    public int remove(){
        if (counter == 0)
            throw new IllegalStateException();
        
        counter--;
        values[first]=0;
        int item =  values[first++];

        if (first == values.length)
            first = 0;

        return item;
        
    }

    public int peek(){
        return values[first];        
    }

    public boolean isEmpty(){
        if (counter == 0)
            return true;
        
        return false;
    }

    public boolean isFull(){
        if (counter == values.length)
            return true;
        
        return false;
    }

    @Override
    public String toString(){
        return Arrays.toString(values);
    }
}
