package FunctionalInterfaces;


public class LambdaDemo {
    public LambdaDemo(String message){

    }

    public static void show(){
        String prefix = "-";

        greet(new ConsolePrinter());

        greet(new Printer(){
            @Override
            public void print(String message) {
                System.out.println(message);
            } //Anonymous interclass
        });

        greet( message -> { System.out.println(prefix + message);}); //lambda function , -> lambda operator

        Printer printer = message -> { System.out.println(message);};

        //or

        greet(System.out::println);

        var demo = new LambdaDemo("");
        greet(message -> demo.print(message)); // Instance lambda func
        greet(demo::print);

        greet(message -> LambdaDemo.printStatic(message)); // Static lambda func
        greet(LambdaDemo::printStatic);

        greet(message -> new LambdaDemo(message)); // Constructor lambda func
        greet(LambdaDemo::new);
    }

    public void print (String message){

    }

    public static void printStatic (String message){

    }

    public static void greet(Printer printer){
        printer.print("Hello world");
    }
}
