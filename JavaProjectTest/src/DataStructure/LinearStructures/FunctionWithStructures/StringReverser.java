package DataStructure.LinearStructures.FunctionWithStructures;

import java.util.Stack;

public class StringReverser {
    public static String stringReverser(String reverse){
        if(reverse==null)
            throw new IllegalArgumentException();
            
        Stack<Character> stack = new Stack<>();
        StringBuffer stringreverse= new StringBuffer();

        for (int i = reverse.length()-1; i>=0; i--){
            var charstring = reverse.charAt(i);
            stack.push(charstring);   
            stringreverse.append(stack.pop());        
        }
        
        return stringreverse.toString();
    }
}
