package DataStructure.NonLinearStructures;

import java.util.Arrays;

public class Heap {
    public int[] heap; 
    private int index = 0;
    

    public Heap(int size){
        heap = new int[size];
    }

    public void insert(int number){
        heap[index] = number;
        bubbleUp(index);
        index++;
    }

    public int remove(int number){
        if(index == 0 )
            throw new IllegalStateException();

        int indexSearch;
        int intReturn;

        //check if there is number
        indexSearch = find(number); // if you only want to remove the top  value
                                    // this function is not necessary and the complexity of this method became O(log n) instead of O(n)
        //bubble down
        indexSearch = bubbleDown(indexSearch);
        intReturn = heap[indexSearch];
        //swap and remove number --> technically the last number is not removed from array just put aside
        swap(index - 1, indexSearch); 
        //bubbleUp new value
        if(index-1 != indexSearch)
            bubbleUp(indexSearch);
        //decrease index
        index--;
        //return value
        return intReturn;

    }

    private int find(int number){
        if(number <= heap[0]){
            for(int i=0; i<index; i++){
                if(heap[i]==number)
                    return i;
            }
        }
        throw new IllegalStateException();
    }

    private int bubbleDown(int index){
        if(isRightChild(index) > this.index &&  isLeftChild(index)>= this.index)
            return index;
             
        if(heap[isRightChild(index)] > heap[isLeftChild(index)] && isRightChild(index) < this.index){
            swap(index,isRightChild(index));
            index = bubbleDown(isRightChild(index));         
        }
        else {
            swap(index,isLeftChild(index));
            index = bubbleDown(isLeftChild(index));         
        }
        
        
        return index;
    }

    private void bubbleUp(int index){
        if(heap[index] > heap[isParent(index)]){
            swap(index,isParent(index));
            bubbleUp(isParent(index));
            return;         
        }
        return;
    }

    private void swap(int index, int swapIndex) {
        int aux;
        aux = heap[index];
        heap[index] = heap[swapIndex];
        heap[swapIndex] = aux;
    }

    private int isLeftChild(int index) {
        return index*2 + 1;
    }

    private int isRightChild(int index) {
        return index*2 + 2;
    }


    private int isParent(int index) {
        return (index-1)/2;
    }

    public boolean isEmpty(){
        if(index == 0 )
            return true;
        
        return false;
    }
    @Override
    public String toString(){
        return Arrays.toString(Arrays.copyOfRange(heap, 0, index));
    }
}
