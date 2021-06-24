package FunctionalInterfaces;

import java.util.function.Function;

public class FunctionDemo {
    public static void show(){
        Function<String, Integer> map = (String str) -> str.length(); 
        var length = map.apply("Sky");
        System.out.println(length);

        //"key:value"
        //first transf: "key=value"
        //second: "{key=value}"
        Function<String,String> replaceColon = str -> str.replace(":", "=");
        Function<String,String> addBraces = str -> "{" + str + "}";
        
        var result = replaceColon
                    .andThen(addBraces)
                    .apply("key:value");

        //or
        
        var result2 = addBraces.compose(replaceColon).apply("key:value");

        System.out.println(result); 

        
    }
}
