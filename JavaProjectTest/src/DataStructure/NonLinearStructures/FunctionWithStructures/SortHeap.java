package DataStructure.NonLinearStructures.FunctionWithStructures;


import DataStructure.NonLinearStructures.Heap;

public class SortHeap {

    public int[] sortInt(int[] sort){
        int i = sort.length-1;
        Heap heap = new Heap(sort.length);

        for(int number : sort)
            heap.insert(number);
        
        while(!heap.isEmpty()){
            sort[i] = heap.remove(heap.heap[0]);
            i--;
        }
            

        return sort;
    }

    public int kLargest(int[] array, int k){
        if(k<1 || k> array.length)
            throw new IllegalArgumentException();

        int kLargest=0;
        Heap heap = new Heap(array.length);

        for(int number : array)
            heap.insert(number);

        for(int i=0; i<k; i++)
            kLargest = heap.remove(heap.heap[0]);

        return kLargest;

    }

    public boolean isMaxHeap(int[] array){

        Heap heap = new Heap(array.length);

        for(int number : array)
            heap.insert(number);

        for(int i=0; i<array.length; i++)
            if(array[i] == heap.heap[i])
                continue;
            else
                return false;

        return true;
    }   
}
