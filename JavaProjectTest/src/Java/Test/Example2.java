package Java.Test;

import java.util.Scanner;

public class Example2 {
    public static void main(String[] args){
        int x =1;
        int y =1;
        System.out.println(x==y);

        int temperature = 32;
        boolean iswarm = temperature >20 && temperature <30;
        
        System.out.println(iswarm);

        boolean hasincome =true;
        boolean hasGoodCredit = true;
        boolean hasCriminalRecord = false;
        boolean eligible = (hasincome || hasGoodCredit) && !hasCriminalRecord;

        System.out.println(eligible);

        if (temperature >30){
            System.out.println("It's a hot day");
            System.out.println("Drink water");
        }
        else if (temperature >20){
            System.out.println("Beatiful day");
        }
        else {
            System.out.println("Cold day");
        }

        int income = 120_000;
        boolean hasHighIncome = (income > 100_000);

        String classname = income > 100_000 ? "First":"Economy";

        String role = "admin";

        switch(role){
            case "admin":
                System.out.println("You're an admin");
                break;

            case "moderator":
                System.out.println("You're an moderator");
                break;
            
            default:
                System.out.println("You're an guest");
                
        }

        for (int i =0; i<5; i++){
            System.out.println("Hello World" + i);
        }

        int i=5;
        while (i>0){
            System.out.println("Hello World" + i);
            i--;
        }

        String input = "";
        Scanner inputObj = new Scanner(System.in);
        while (input.equals("quit")){
            System.out.print("Input:");
            input = inputObj.nextLine().toLowerCase();
            System.out.println(input);
        }

        input= "";
        do{
            System.out.print("Input:");
            input = inputObj.nextLine().toLowerCase();
            System.out.println(input);           
        }
        while (!input.equals("quit"));

        input = "";

        while(true){
            System.out.print("Input:");
            input = inputObj.nextLine().toLowerCase();
            if (input.equals("pass"))
                continue;
            if (input.equals("quit"))
                break;    
            System.out.println(input);           
        }

        String[] fruits = {"Apple","Mango", "Orange"};

        for (int j =0; j< fruits.length;j++)
            System.out.println(fruits[j]);

        for (String fruit : fruits)
            System.out.println(fruit);

    }
}
