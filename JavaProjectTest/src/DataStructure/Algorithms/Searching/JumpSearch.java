package DataStructure.Algorithms.Searching;

public class JumpSearch {// Time complexity -> O(sqrt(n))
    public int jumpSearch(int[] array, int number){
        int blocksize =(int) Math.sqrt( array.length);
        int start = 0;
        int next = blocksize;

        while(start < array.length){
            if(number > array[next-1]){
                start = next;
                next = next+blocksize;
            
                if(next>array.length)
                    next = array.length;

            }
            else{
                for(int i = start; i< next; i++)
                    if(number == array[i])
                        return i;
                
                break;
            }
        }
        return -1;
    }
    
}
