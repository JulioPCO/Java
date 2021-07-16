package Projects.BankProject;

import java.util.Scanner;

public class Console {
    public static String[] console(){
        Scanner scanner = new Scanner(System.in);
        String [] information = new String[2];

        System.out.print("Login: ");
        information[0] = scanner.nextLine();
        System.out.print("Password: ");
        information[1] = scanner.nextLine();

        return information;

    }
}
