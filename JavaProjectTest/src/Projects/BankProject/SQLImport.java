package Projects.BankProject;

import java.sql.*;

public class SQLImport {
    public static void sqlImport(String Login, String Password){
        try {

            String url = "jdbc:sqlite:C:\\Users\\Julio\\Desktop\\coding\\Java\\JavaExercises\\JavaProjectTest\\src\\Projects\\BankProject\\BankDatabase.db";
            Connection conn = DriverManager.getConnection(url);

            Statement stmt = conn.createStatement();

            try{
                String sqlString = "SELECT * FROM users WHERE login='"+ Login + "';";

                ResultSet rset = stmt.executeQuery(sqlString);

                while(rset.next()) {   // Repeatedly process each row
                    //String name = rset.getString("name");  // retrieve a 'String'-cell in the row
                    //int userid = rset.getInt("userid");    
                    String password  = rset.getString("password");  
                    double balance = rset.getDouble("balance");
                    
                    if (password.compareTo(Password) == 0){
                        Balance.setBalance(balance);
                    }else{
                        System.out.println("Wrong Password");
                        System.exit(0);
                    }
                }
            }catch (SQLException e){
                System.out.println("Login or Password not found");
                System.exit(0);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }        
    }

    public static void sqlExport(String Login, String Password){
        try {

            String url = "jdbc:sqlite:C:\\Users\\Julio\\Desktop\\coding\\Java\\JavaExercises\\JavaProjectTest\\src\\Projects\\BankProject\\BankDatabase.db";
            Connection conn = DriverManager.getConnection(url);

            Statement stmt = conn.createStatement();

            String sqlString = "UPDATE users SET balance=" + Double.valueOf(Balance.getBalance()) +" WHERE login='"+ Login + "';";
            stmt.executeUpdate(sqlString);


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }        
    }    
}
