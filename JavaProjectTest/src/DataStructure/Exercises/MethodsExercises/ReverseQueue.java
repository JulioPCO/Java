package DataStructure.Exercises.MethodsExercises;

import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {
    public static void reverseQueue(Queue<Integer> queue){
        Stack<Integer> stack = new Stack<>();
       
        while(queue.isEmpty() == false)
            stack.push(queue.remove());           
        

        while(stack.isEmpty()==false)
            queue.add(stack.pop());

        
    }

    public static void reverseQueue(Queue<Integer> queue, int k){
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        int count =0;
        int count2 =0;
        
        while(!queue.isEmpty()){
            if (count >= k)
                stack2.push(queue.remove());
            else
                stack1.push(queue.remove()); 
            count++;
        }          
            

        while(!stack2.isEmpty() ){
            if (count2 >= k){
                stack1.push(stack2.pop());
            }
            else
                queue.add(stack1.pop());
            count2++;
        }

        while(!stack1.isEmpty() )
            queue.add(stack1.pop());
    }    
}
