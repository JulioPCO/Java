package DataStructure.Algorithms.Searching;

public class LinearSearching { // Best-> o(1) Worst -> O(n)
    public void linearSearching(int[] array, int number){
        for (int i=0;i<array.length;i++) {
            if(number == array[i]){
                System.out.println("index is: " + i);
                return;
            }
        }

        System.out.println("Not in array");
        return;
    }
    
}
