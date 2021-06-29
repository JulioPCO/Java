package DataStructure.LinearStructures;

import java.util.HashMap;
import java.util.Map;

public class Array {
    private int counter;
    private int[] array;

    public Array(int length){
        array = new int[length];
    }

    public void insert(int number){
        if (counter < array.length){
            array[counter] = number;
        }else{
            int[] newArray = new int[2*array.length];
            
            for(int i = 0; i<array.length; i++)
                newArray[i]=array[i];
            
            newArray[counter] = number;

            array = newArray;
        }
        counter++; // Pensar em um jeito de mudar isso, deixa o código cheio de i+1 e i-1
    }

    public void insertAt(int index, int number){
        if (counter > index){
            this.insert(array[counter-1]);

            for (int i=index; i < counter -2; i++)
                array[i+1]=array[i];
            array[index]=number;
        }
        else
            System.out.println("Index out of range");
            
    }

    public void remove(int index){
        if(index <0 || index>=counter)
            System.out.println("Index out of range");
        else{    
            for (int i = index; i<counter; i++)
                array[i] = array[i+1];
            array[counter] = 0;
            counter--;
        }       
    }

    public void printArray(){
        for(int i=0;i<counter;i++){
            System.out.println(array[i]);
        }
    }

    public int indexOf(int number){
        for(int i=0; i<counter; i++){
            if(array[i]==number)
                return i;
        }   
        return -1;
        
    }

    public int Max(){
        int max = array[0];

        for (int i =0; i < array.length; i++){
            if (array[i] >= max){
                max = array[i];
            }
        }
        
        return max;
    }

    public Array intersect(Array otherArray){
        Array intersect = new Array(array.length);

        for (int i = 0; i< array.length;i++){
            for(int j = 0; j<otherArray.array.length; j++){
                if(array[i] == otherArray.array[j]){
                    intersect.insert(array[i]);
                    break;
                }
            }
        }

        return intersect;
    }

    public Array intersectHashMap(Array otherArray){
        Array intersect = new Array(array.length);
        Map<Integer,Integer> mapping = new HashMap<>();
        
        for(int i = 0; i< array.length; i++)
            mapping.put(array[i], array[i]);

        for(int j = 0; j<otherArray.array.length; j++){
            if (mapping.containsValue(otherArray.array[j]))
                intersect.insert(otherArray.array[j]);
        }


        return intersect;
    }

    public Array reverseArray(){
        Array reverse = new Array(array.length);

        for(int i = counter-1; i>=0; i--)
            reverse.insert(array[i]);

        return reverse;
    }
}
