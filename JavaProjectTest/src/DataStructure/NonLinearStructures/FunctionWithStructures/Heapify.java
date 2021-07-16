package DataStructure.NonLinearStructures.FunctionWithStructures;

public class Heapify { //transform an array into an heapfied version of the array

    public int[] heapify(int[] array){ // heapify is the process make adjust tree so the leafs are lower or greater depending if max or min heapify, respectively
                                       // to heapify a complete tree each subtree must be heapified. So it should start from the last subtree to the complete tree.
                                       // heapify is a recursive technique.
        var lastParentIndex =array.length/2 - 1;
        for(int i= lastParentIndex; i>=0 ; i--)
            heap(array, i);
  
        return array;
    }
    int aux;

    private void heap(int[] array, int index){
        var largerIndex = index;

        var leftIndex = 2*index +1;
        var rightIndex = 2*index +2;

        if(leftIndex < array.length && array[leftIndex] > array[largerIndex]){
            largerIndex = leftIndex;
        }

        if(rightIndex < array.length && array[rightIndex] > array[largerIndex]){
            largerIndex = rightIndex;
        }

        if (index == largerIndex)
            return;

        swap(array, index, largerIndex);
        heap(array, largerIndex);
    }

    private void swap(int[] array, int first, int second){
        var temp = array[first];
        array[first] = array[second];
        array[second] = temp;

    }
}
