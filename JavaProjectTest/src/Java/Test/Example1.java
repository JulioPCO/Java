package Java.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.awt.Point;
import java.text.NumberFormat;

public class Example1 {

    public static void main(String[] arg){
        int myAge =30;
        int herAge = myAge; 
        System.out.println(herAge);

        byte age = 30;
        long viewsCount= 3_123_456_789L;
        float price = 10.99F;
        char letter = 'A';
        boolean iseligible = true;

        Date now = new Date();
        System.out.println(now);

        byte x =1;
        byte y =x;

        x=2;
        System.out.println(y);

        Point point1 = new Point(1,1);
        Point point2 = point1;

        point1.x = 2;
        System.out.println(point2);

        String message =  new String("Hello World");
        String message1 = "Hello Everybody" + "!!";
        System.out.println(message1.length());
        System.out.println(message1.indexOf("sky"));

        String message2 = "Hello \"Mosh\"";
        String message3 = "c:\n\t\\Windows\\...";
        System.out.println(message3);

        int[] numbers = new int[5];
        numbers[0] = 1;
        numbers[1] = 2;
        System.out.println(numbers);

        Arrays.toString(numbers);
        System.out.println(Arrays.toString(numbers));

        int[] numbers2 = {2,3,5,1,4};
        Arrays.sort(numbers2);
        System.out.println(Arrays.toString(numbers2));

        int[][] numbers3 = new int[2][3];
        numbers3[0][0] = 1;
        System.out.println(Arrays.deepToString(numbers3));

        int[][] numbers4 = {{1,2,3}, {4,5,6}};
        System.out.println(Arrays.deepToString(numbers4));

        final float pi = 3.1415F;

        int result = 10+3;
        double result2 = (double)10 / (double)3;

        int x2=1;
        x2++;
        x2 += 2;

        short x3=1;
        int y3 =x3+2;
        System.out.println(y3);

        double x4 = 3.3;
        int y4 = (int)x4 + 2;
        System.out.println(y4);

        String x5 = "1";
        int y5 = Integer.parseInt(x5) +6;
        System.out.println(y5);
        
        int result4 = (int)Math.ceil(1.1F);
        System.out.println(result4);

        int randomnumber = (int) (Math.random()*100);
        System.out.println(randomnumber);

        NumberFormat currency =  NumberFormat.getCurrencyInstance();
        String result3 =currency.format(1234567.891);
        System.out.println(result3);

       // Scanner scannerobject = new Scanner(System.in);
       // System.out.print("Age: ");
       // byte age1 = scannerobject.nextByte();
       // System.out.println("You are " + age1);

        Scanner scannerobject2 = new Scanner(System.in);
        System.out.print("Name: ");
        String name2 = scannerobject2.nextLine().trim();
        System.out.println("You are " + name2);   
        scannerobject2.close();     
    }
}