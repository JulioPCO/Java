package DataStructure.NonLinearStructures.FunctionWithStructures;

public class MinHeapPriorityQueue {
    MinHeapNodes heap = new MinHeapNodes();
    public void enqueue( String value, int priority){
        heap.insert(priority, value);
    }

    public void dequeue(){
        heap.remove();
    }

    public void isEmpty(){
        heap.isEmpty();
    }
}
