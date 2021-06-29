package DataStructure.LinearStructures;

import java.util.Arrays;

public class Stack {
    int[] stack;
    int[] keep;
    int count=0;
    int length = 3;
    

    public Stack(){
        stack = new int[length];
    }

    public void push(int value){
        if (count+1 > length){
            keep = stack;
            length = length*2;
            stack = new int[length];
            
            for (int i = 0; i < keep.length; i++)
                stack[i] = keep[i];
        }
                
        stack[count++] = value;
    }

    public void pop(){
        if (count == 0)
            throw new IllegalStateException();

        stack[--count] = 0;
    }

    public int peek(){
        if (count == 0)
            throw new IllegalStateException();

        return stack[count-1];
    }

    public boolean isEmpty(){
        if (count == 0)
            return true;
        
        return false;
    }

    @Override
    public String toString(){
        var content = Arrays.copyOfRange(stack, 0, count);
        return Arrays.toString(content);
    } 


    
}
