package DataStructure.Algorithms.Searching;

public class ExponentialSearch {// Time complexity ->O(log i)
    public int exponentialSearch(int[] array, int number){
        int bound = Math.min(1, array.length-1);
        int start = 0;

        if(array.length == 0 )
            return -1;

        while(bound< array.length && number > array[bound]){ 
            start = bound;
            bound = 2* bound;
            
            if(bound>array.length)
                bound = array.length-1;
                
            if(start == bound)
                return -1;
        }

        for(int i = bound/2; i< bound+1; i++)
            if(number == array[i])
                return i;
    
        return -1;
        
    }
    
}
