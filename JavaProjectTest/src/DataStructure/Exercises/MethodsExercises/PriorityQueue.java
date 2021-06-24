package DataStructure.Exercises.MethodsExercises;

import java.util.Arrays;

public class PriorityQueue {
    private int[] values;
    private int counter = 0;

    public PriorityQueue(int length){
        values = new int[length];
    }

    public void add(int item){
        if (counter == values.length)
            throw new IllegalStateException();

        if (counter == 0)
            values[counter] = item;
        else{
            this.shiftToInsert(item);
        } 

        counter++;
    }

    private void shiftToInsert(int item){

        for(int i = counter; i>0; i--){
            if(item<values[i-1]){
                values[i] = values[i-1];
                values[i-1] = item;
            }
            else{
                values[i] = item;
                break;
            }
        }

    }

    public int remove(){
        if (counter == 0)
            throw new IllegalStateException();

        int item = values[0];
        counter--;

        for(int i = 0; i<counter; i++){
            values[i] = values[i+1];
        }

        
        return item;

    }

    @Override
    public String toString(){
        return Arrays.toString(values);
    }

}
