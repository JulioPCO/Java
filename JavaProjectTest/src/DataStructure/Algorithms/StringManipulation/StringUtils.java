package DataStructure.Algorithms.StringManipulation;


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class StringUtils {

    public static void vowels(String sentence){
        if(sentence == null)
            throw new IllegalArgumentException();

        int count = 0;
        String vowel = "aeiou";
        for(char ch: sentence.toLowerCase().toCharArray())
            if(vowel.contains(Character.toString(ch)))
                count++;

        System.out.println(count);
    }
    
    public static void reverseString(String sentence){
        if(sentence == null)
            throw new IllegalArgumentException();

        Stack<Character> stack = new Stack<>();

        for(char ch : sentence.toCharArray())
            stack.add(ch);

        StringBuilder reverse = new StringBuilder();

        while(!stack.isEmpty())
            reverse.append(stack.pop());

        System.out.println(reverse);
    }

    public static void reverseString2(String sentence){
        if(sentence == null)
            throw new IllegalArgumentException();

        StringBuilder reverse = new StringBuilder();
        for(int i = sentence.length()-1; i >= 0;i--)
            reverse.append(sentence.charAt(i)); // String builder operates at O(1) to build string, if we used an empty string, new strings would be created each iteration
                                                // and iterate over the length of the string to an O(n) operation
            

        System.out.println(reverse);
    }

    public static void reverseWords(String sentence){
        if(sentence == null)
            throw new IllegalArgumentException();

        Stack<String> stack = new Stack<>();
        StringBuilder reverse = new StringBuilder();

        for(String word : sentence.split(" ")){
             stack.add(word);
        }

        while(!stack.isEmpty()){
            reverse.append(stack.pop());
            reverse.append(" ");
        }

        System.out.println(reverse.toString().substring(0, reverse.length()-1));

    }

    public static void reverseWords2(String sentence){
        if(sentence == null)
            throw new IllegalArgumentException();

        var words = sentence.split(" ");
        StringBuilder reverse = new StringBuilder();

        for(int i=words.length -1; i>=0; i--){
             reverse.append(words[i]);
             reverse.append(" ");
        }

        

        System.out.println(reverse.toString().trim());

    }

    public static void rotation(String sentence1, String sentence2){
        int index = sentence2.indexOf(sentence1.charAt(0));
        StringBuilder sentence2Ordered = new StringBuilder();

        if (index == -1){
            System.out.println("false");
            return;
        }

        while(sentence2Ordered.toString().length() < sentence2.length()){
            sentence2Ordered.append(sentence2.charAt(index));
            index++;
            if(index > sentence2.length()-1)
                index=0;
        }

        if(sentence1.equals(sentence2Ordered.toString())){
            System.out.println("true");
            return;
        }

        System.out.println("false");        
    }

    public static void rotationSolution(String sentence1, String sentence2){
        if(sentence1 == null || sentence2 == null)
            throw new IllegalArgumentException();

        // can be onelined by -> return (sentence1.length() == sentence2.length() && (sentence1+sentence1).contains(sentence2));
        if(sentence1.length() != sentence2.length()){
            System.out.println("false");
            return;
        }

        if(!(sentence1+sentence1).contains(sentence2)){
            System.out.println("false");
            return;
        }

        System.out.println("true");
    }

    public static void removeDuplicates(String sentence){
        if(sentence == null)
            throw new IllegalArgumentException();

        Set<Character> set = new HashSet<>();
        StringBuilder noRepetition = new StringBuilder();

        for(char ch : sentence.toCharArray())
            if (!set.contains(ch)){
                set.add(ch);
                noRepetition.append(ch);
            }

        System.out.println(noRepetition);
        
    }

    public static void mostRepeated(String sentence){
        if(sentence == null)
            throw new IllegalArgumentException();

        Map<Character, Integer> map = new HashMap<>(); // can be done by creating an int array with the length of ASCII and adding to this vector every occurence of the converted value of the 
                                                      // character to int -> 'a' = 61 -> int[61]++;

        for(var ch : sentence.toCharArray())
            if(!map.containsKey(ch)){
                map.put(ch, 1);
            }
            else
                map.replace(ch, map.get(ch)+1);

        int max = 0;
        char mostRepeated = ' ';
        for(char ch : map.keySet())
            if(map.get(ch)> max){
                max = map.get(ch);
                mostRepeated = ch;
            }

        
        System.out.println(mostRepeated);
    }

    public static void capitilizeFirstLetter(String sentence){
        if(sentence == null)
            throw new IllegalArgumentException();

        if(sentence.trim().isEmpty())
            return;

        var split = sentence.trim().replaceAll(" +", " ").split(" "); //" +" one or more white spaces!!
        StringBuilder capitalized = new StringBuilder();

        for(var word: split){
            var upperChar = Character.toUpperCase(word.charAt(0));
            capitalized.append(upperChar + word.substring(1, word.length()).toLowerCase() + " ");
        }

        System.out.println("'" + capitalized.toString().trim() + "'");
    }

    public static void anagrams(String sentence1, String sentence2){ // O(n log n)
        if(sentence1 == null || sentence2 == null)
            throw new IllegalArgumentException();

        if(sentence1.length() != sentence2.length()){
            System.out.println("false");
            return;
        }
 
        var list1 = sentence1.toLowerCase().toCharArray();
        var list2 = sentence2.toLowerCase().toCharArray();

        Arrays.sort(list1);
        Arrays.sort(list2);

        if(Arrays.equals(list1, list2)){
            System.out.println("true");
            return;
        }

        System.out.println("false");
        
    }

    public static void anagramsHistograms(String sentence1, String sentence2){ //O(n)
        if(sentence1 == null || sentence2 == null)
            throw new IllegalArgumentException();

        if(sentence1.length() != sentence2.length()){
            System.out.println("false");
            return;
        }

        final int letters = 26;
        int[] frequencies = new int[letters];

        sentence1.toLowerCase();
        sentence2.toLowerCase();

        for(var i=0; i<sentence1.length(); i++)
            frequencies[sentence1.charAt(i) - 'a']++;

        for(var i=0; i<sentence2.length();i++){
            var index = sentence2.charAt(i) -'a';

            if(frequencies[index] ==0){
                System.out.println("false");
                return;
            }
    
            frequencies[index]--;
        }

        System.out.println("true");
            
    }

    public static void palindrome(String sentence1){
        if(sentence1 == null)
            throw new IllegalArgumentException();

        StringBuilder reverse = new StringBuilder();
        sentence1.toLowerCase();

        for(int i = sentence1.length()-1; i >= 0;i--)
            reverse.append(sentence1.charAt(i)); // String builder operates at O(1) to build string, if we used an empty string, new strings would be created each iteration
                                                // and iterate over the length of the string to an O(n) operation
            

        if(sentence1.equals(reverse.toString())){
            System.out.println("true");
            return;
        }

        System.out.println("false");
    }

    public static void palindrome2(String sentence1){
        if(sentence1 == null)
            throw new IllegalArgumentException();

        int left = 0;
        int right = sentence1.length()-1;

        var array = sentence1.toCharArray();

        while(left <= right){
            if(array[left] != array[right]){
                System.out.println("false");
                return;
            }

            left++;
            right--;

        }

        System.out.println("true");
    }
}
