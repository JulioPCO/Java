package Projects.Mortgage;

import java.util.Scanner;

public class Console {
    private static Scanner scanner = new Scanner(System.in);

    public static double readNumber(String prompt, double min, double max){
        System.out.print(prompt);
        double value = scanner.nextInt();
        while (value < min || value >max){
            System.out.println("Enter a number between:" + min + "and" + max);
            System.out.print(prompt);
            value = scanner.nextInt();
            }

        return value;
    }
}
