package Java.Test;

public class Example3{
    private static Browser browser;

    public static void main(String[] args){
        var TextBox1 = new TextBox();
        TextBox1.setText("Box 1");
        System.out.println(TextBox1.text.toUpperCase());

        var TextBox2 = new TextBox();
        TextBox2.setText("Box 2");
        System.out.println(TextBox2.text);

        var employee = new Employee(50_000,20);
        //employee.setBaseSalary(50000);
        //employee.hourlyRate = 20;

        int wage = employee.calculateWage(10);
        System.out.println(wage);

        var browser = new Browser();
        
    }
}