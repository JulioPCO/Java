package DataStructure.LinearStructures.FunctionWithStructures;

import java.util.Arrays;

public class MinStack {
    int[] stack;
    int value;
    int remember;
    int count=0;
    int length = 5;
    

    public MinStack(){
        stack = new int[length];
    }

    public void push(int value){                      
        if(count == 0){
            this.value = value;
            remember = value;
        }
        else{
            if(this.value>value){
                remember = this.value;
                this.value = value;
            }
        }

        stack[count++] = value;
        
    }

    public int min(){
        if (count == 0)
            throw new IllegalStateException();
            
        return this.value;
    }

    public void pop(){
        if (count == 0)
            throw new IllegalStateException();
        
        if(this.value == stack[count-1] && count > 1){
            this.value = remember;
        }

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
