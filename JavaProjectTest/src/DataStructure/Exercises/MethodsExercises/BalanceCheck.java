package DataStructure.Exercises.MethodsExercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


public class BalanceCheck {
    private final List<Character> expressionChecker = Arrays.asList('(','[','{','<');

    public boolean balanceCheck(String equation){
        Stack<Character> checker = new Stack<>();
        ArrayList<Boolean> validation = new ArrayList<>();
        
        Boolean check=false;
        int count = 0;
        
        for (int i=0; i<equation.length(); i++){
            char expression = equation.charAt(i);

            if( expressionChecker.contains(expression)){
                count = 1;
                checker.push(expression);
            }
                           
             validation.add(matchBrackets('<','>',checker,expression));
             validation.add(matchBrackets('{','}',checker,expression));
             validation.add(matchBrackets('[',']',checker,expression));
             validation.add(matchBrackets('(',')',checker,expression));
                        
             if (validation.contains(false))
                return false;

        }

        if (count == 0 || checker.isEmpty() == false)
            check =false;
        else 
            check = true;

        return check;
    }

    private boolean matchBrackets(char left, char right, Stack<Character> checker, char expression){
        if (expression == right ){
            if (checker.isEmpty()== true)
                return false;
            if (checker.peek() != left)
                return false;
            checker.pop();    
        }  
        return true;
    }

}
