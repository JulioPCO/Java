package DataStructure.Algorithms.Searching;

public class BinarySearching { // Time complexity-> O(log n) / Space complexity -> Recursive-> O(log n) Iterative -> O(1), only work for sorted arrays

    public int binarySearchingRecursive(int[] array, int number){
        
        int index = binarySearchingRecursive(array, 0, array.length-1, number);

        return index;
       
    }
    private int binarySearchingRecursive(int[] array, int start, int end, int number){
        int middle = (start+end)/2;

        if(number == array[middle])
            return middle;
        
        if(end < start)
            return -1;

        if(number> array[middle])
           return binarySearchingRecursive(array,middle+1, end,number);
        else
           return binarySearchingRecursive(array,start, middle-1,number);
        

        

    }

    public int binarySearchingIterative(int[] array, int number){
        int pointerleft=0;
        int pointerright =array.length;
        int index = -1;

        while(pointerleft <= pointerright){
            int middle = (pointerleft+pointerright)/2;
            if(number == array[middle]){
                index = middle;
                break;
            }

            if(number > array[middle])
                pointerleft=middle+1;
            else
                pointerright = middle-1;

        }

        return index;
    }
    
}
