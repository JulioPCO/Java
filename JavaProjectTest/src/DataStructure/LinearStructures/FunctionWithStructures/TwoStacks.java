package DataStructure.LinearStructures.FunctionWithStructures;

import java.util.Arrays;

public class TwoStacks {
    int[] stack1;
    int count1=0;
    int count2=5;
    int length = 6;
    

    public TwoStacks(){
        stack1 = new int[length];
    }

    public void push1(int value){ 
        if (isFull() == true)    
            throw new IllegalStateException();         
        stack1[count1++] = value;
    }

    public void push2(int value){  
        if (isFull() == true)    
            throw new IllegalStateException();              
        stack1[count2--] = value;
    }

    public void pop1(){
        if (count1 == 0)
            throw new IllegalStateException();

        stack1[++count1] = 0;
    }

    public void pop2(){
        if (count2 == 5)
            throw new IllegalStateException();

        stack1[++count2] = 0;
    }

    public int peek1(){
        if (count1 == 0)
            throw new IllegalStateException();

        return stack1[count1-1];
    }

    public int peek2(){
        if (count2 == 5)
            throw new IllegalStateException();

        return stack1[count2+1];
    }

    public boolean isEmpty1(){
        if (count1 == 0)
            return true;
        
        return false;
    }

    public boolean isEmpty2(){
        if (count2 == 5)
            return true;
        
        return false;
    }

    public boolean isFull(){
        if (count1 > count2)
            return true;
        
        return false;
    }

    @Override
    public String toString(){
        var content1 = Arrays.copyOfRange(stack1, 0, length);
        //var content2 = Arrays.copyOfRange(stack1, 3, count2);
        return Arrays.toString(content1);
    } 


}
