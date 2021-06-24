package ExercisesJava;

import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args){
        System.out.print("Number:");
        Scanner numberobj = new Scanner(System.in);
        int number = numberobj.nextInt();
        boolean divisible5 = number%5==0;
        boolean divisible3 = number%3==0;

        if (divisible5 == true && divisible3 == true){
            System.out.println("FizzBuzz");
        }
        else if (divisible5 == true && divisible3 == false){
            System.out.println("Fizz");
        }
        else if (divisible5 == false && divisible3 == true){
            System.out.println("Buzz");
        }
        else{
            System.out.println(number);
        }
    
    
    }   
}
