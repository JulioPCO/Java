package Exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ExceptionsDemo {
    public static void showUncheckedException(){
        sayHello(null); // runtime exception: invalid number that should have been considered before. It isn't checked by the code
    }

    /* public static void showCheckedException(){
        var reader = new FileReader("file.txt"); // checks that there is no file.txt and throws an exception
    } */

    public static void showCatchException(){
        try{
            var reader = new FileReader("file.txt"); 
            var value = reader.read();
            System.out.println("File Opened");
            new SimpleDateFormat().parse("");
        }
        catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        catch(IOException ex){
            System.out.println("Could not read data."); // the order matters sometimes
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void showCombinedCatchException(){
        try{
            var reader = new FileReader("file.txt"); 
            var value = reader.read();
            System.out.println("File Opened");
            new SimpleDateFormat().parse("");
        }
        catch(IOException | ParseException ex){
            System.out.println("Could not read data."); // the order matters sometimes
        }
    }

    public static void showFinallyException(){
        FileReader reader = null;
        try{
            reader = new FileReader("file.txt"); 
            var value = reader.read();
            System.out.println("File Opened");
            new SimpleDateFormat().parse("");
        }
        catch(IOException | ParseException ex){
            System.out.println("Could not read data."); // the order matters sometimes
        }
        finally{
            if (reader != null)
                try{
                    reader.close();
                }
                catch (IOException ex){
                    ex.printStackTrace(); 
                }
        }
    }


    public static void showTryWithStatementsException(){
        try(var reader = new FileReader("file.txt");){ // this statement already close the file automatically, just like the finally       
            var value = reader.read();
            System.out.println("File Opened");
            new SimpleDateFormat().parse("");
        }
        catch(IOException | ParseException ex){
            System.out.println("Could not read data."); // the order matters sometimes
        }
    }

    public static void sayHello(String name){
        System.out.println(name.toUpperCase());
    }
}
