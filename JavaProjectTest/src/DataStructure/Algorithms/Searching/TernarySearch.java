package DataStructure.Algorithms.Searching;

public class TernarySearch { // Time Complexity O(log3 n)
    public int ternarySearch(int[] array, int number){
        int left = 0;
        int right = array.length-1;
        

        while(left<= right){
            int partitionSize = (right-left)/3;
            int mid1 = left + partitionSize;
            int mid2 = right - partitionSize;

            if(number == array[mid1])
                return mid1;
            

            if(number == array[mid2])
                return mid2;
            

            if(number < array[mid1])
                right = mid1-1;
            
            if(number> array[mid1] && number < array[mid2]){
                right=mid2-1;
                left=mid1+1;
            }

            if(number>array[mid2])
                left = mid2+1;

        }

        return -1;
    }

    
}
