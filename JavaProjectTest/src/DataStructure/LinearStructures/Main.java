package DataStructure.LinearStructures;

//import java.util.ArrayDeque;
import java.util.Arrays;
//import java.util.Queue;

import DataStructure.LinearStructures.MethodsExercises.BalanceCheck;
import DataStructure.LinearStructures.MethodsExercises.MinStack;
import DataStructure.LinearStructures.MethodsExercises.StringReverser;


public class Main {
    public static void main(String[] args){
        Array test = new Array(3);
        //Array test2 = new Array(5);
        test.printArray();

        LinkedList linkedlist = new LinkedList();     
        linkedlist.addFirst(40);
        System.out.println(Arrays.toString(linkedlist.toArray()));
        
        String reverse = "((ab)d";
        BalanceCheck check = new BalanceCheck();
        System.out.println(check.balanceCheck(reverse));
        System.out.println(StringReverser.stringReverser(reverse));

        //Stack stack = new Stack();
        //TwoStacks twostack = new TwoStacks();
        //StackwithTwoQueue stack2q = new StackwithTwoQueue();
        MinStack minstack = new MinStack();       
        System.out.println(minstack.toString());

        //Queue<Integer> queue = new ArrayDeque<>();
        //Queue queue = new Queue(5);
        //QueueWithStacks queue = new QueueWithStacks();
        //PriorityQueue queue = new PriorityQueue(5);
        //QueueLinkedList queue = new QueueLinkedList();
        
        //char s = NonRepeated.findRepeatedCharacter("a green apple");

        //Hash map = new Hash();
    

        
        
        
        




        
    }
    
}
