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
}
