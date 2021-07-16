package DataStructure.NonLinearStructures.FunctionWithStructures;

import DataStructure.NonLinearStructures.Heap;

public class PriorityQueueHeap {
    private Heap heap = new Heap(100);
    public void enqueue(int item){
        heap.insert(item);
    }

    public int dequeue(){
        return heap.remove(heap.heap[0]);
    }

    public boolean isEmpty(){
        return heap.isEmpty();
    }
}
