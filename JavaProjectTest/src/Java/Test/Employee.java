package Java.Test;

public class Employee {
    private int baseSalary;
    private int hourlyRate;

    public static int numberOfEmployees;

    public Employee(int baseSalary, int hourlyRate){
        setBaseSalary(baseSalary);
        setHourlyRate(hourlyRate);
        numberOfEmployees++;
    }
    
    public Employee(int baseSalary){
        this(baseSalary,0);
    }

    //public Employee(int baseSalary){
    //    setBaseSalary(baseSalary);
    //    setHourlyRate(0);
    //}

    public static void printNumberOfEmployee(){
        System.out.println(numberOfEmployees);
    }

    public int calculateWage(int extraHours){
        return baseSalary + (hourlyRate*extraHours);
    }

    public int calculateWage(){
        return calculateWage(0);
    }

    private void setBaseSalary(int baseSalary){
        if (baseSalary <= 0)
            throw new IllegalArgumentException("Salary cannot be 0 or less");
        this.baseSalary = baseSalary;
    }

    protected int getBaseSalary(){
        return baseSalary;        
    }

    private void setHourlyRate(int hourlyRate){
        if (hourlyRate < 0)
            throw new IllegalArgumentException("Hourly rate cannot be 0 or less");
        this.hourlyRate = hourlyRate;        
    }

    protected int getHourlyRate(){
        return hourlyRate;
    }
}
