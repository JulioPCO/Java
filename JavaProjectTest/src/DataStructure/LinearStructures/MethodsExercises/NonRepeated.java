package DataStructure.LinearStructures.MethodsExercises;


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NonRepeated {
    public static char findNonRepeatedCharacter(String args){
        //find first non repetead character
        Map<Character, Integer> map = new HashMap<>();
        var chars = args.toCharArray();

        for(char ch: chars){
            var count = map.containsKey(ch) ? map.get(ch) : 0;
            map.put(ch, count+1);  

            //or
            /* if(map.containsKey(ch)){
                var count = map.get(ch);
                map.put(ch, count + 1);
            }
            else{
                map.put(ch, 1);
            } */
            
        }

        for(char ch: chars)
            if(map.get(ch)==1)
                return ch;
        
        return Character.MIN_VALUE;
    }

    //find first  repetead character
    public static char findRepeatedCharacter(String args){
        //find first non repetead character
        Set<Character> map = new HashSet<>();
        var chars = args.toCharArray();

        for(char ch: chars){           
             if(map.contains(ch)){
                return ch;
            }           
                map.add(ch);                   
        }

        
        return Character.MIN_VALUE;        
    }

    public static int mostFrequent(int[] array){
        Map<Integer, Integer> map = new HashMap<>();
        int mostFrequent = 0;
        int value = 0;
        

        for(int number: array){
            if (map.containsKey(number))
                map.put(number, map.get(number) +1);
            else
                map.put(number,1);
        }

        for( int keys : map.keySet()){
            if(value < map.get(keys)){
                value = map.get(keys);
                mostFrequent = keys;
            }
        }


        return mostFrequent;
    }

    public static int countPairWithDifference(int[] array, int k){
        Set<Integer> map = new HashSet<>();
        int countPairs=0;

        for(int number : array){
            map.add(number);
        }

        for (int number : array){
            if(map.contains(number+k))
                countPairs++;
            if(map.contains(number-k))
                countPairs++;
            
            map.remove(number);
        }
        return countPairs;
    }

    public static String twoSums(int[] array, int target){
        Map<Integer,Integer> map = new HashMap<>();
        int[] indices = new int[array.length];
        int indice = 0;
        int count =0;

        for(int number : array){
            map.put(number,indice);
            indice++;
        }

        for(int number : array){
            if (map.containsKey(target - number)){
                indices[count] = map.get(number);
                count++;
            }           
        }

        var ind = Arrays.copyOfRange(indices, 0, count);
        
        return Arrays.toString(ind);
    }
}
