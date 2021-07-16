package DataStructure.LinearStructures.FunctionWithStructures;
import java.util.Stack;

public class QueueWithStacks {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void add(int value){
        stack1.push(value);
    }

    public int remove(){
        if (stack1.isEmpty() == true && stack2.isEmpty() == true)
            throw new IllegalStateException();

        if (stack2.isEmpty() == true){
            while (stack1.isEmpty() == false)
                stack2.push(stack1.pop());
        }

        return stack2.pop();

    }

    public int peek(){
        if (stack1.isEmpty() == true && stack2.isEmpty() == true)
        throw new IllegalStateException();

        if (stack2.isEmpty() == true){
        while (stack1.isEmpty() == false)
            stack2.push(stack1.pop());
        }

        return stack2.peek();
    }

    public boolean isEmpty(){
        if (stack1.isEmpty() == true && stack2.isEmpty() == true)
            return true;
        return false;
    }

    @Override
    public String toString(){
        return stack1.toString();
    }

}
