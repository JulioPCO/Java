package DataStructure.NonLinearStructures.FunctionWithStructures;

public class MinHeapNodes {
    Node[] arrayNodes = new Node[100];
    int size = 0;  
    int indexSearch;  
    Node aux;

    public void insert(int key, String value){
        arrayNodes[size]= new Node(key,value);
        //bubble up the inserted Node
        bubbleUp(size);
        size++;

    }

    public Node remove(){
        Node removed;
        // search were to find the item to be removed
        indexSearch = bubbleDown(0);
        //change the last Node with the Node to be removed
        swap(indexSearch, size-1);
        // bubble up this last Node so it is minHeap
        bubbleUp(indexSearch);
        //store removed Node
        removed = arrayNodes[size];
        //decrease size 
        size--;
        //return removed node
        return removed;
    }

    public boolean isEmpty() {
        if(size == 0)
            return true;

        return false;
    }

    private void bubbleUp(int index){
        if(size == 0)
            return;
            
        if(arrayNodes[index].key < isParent(index).key){
            swap(isParentIndex(index), index);
            bubbleUp(isParentIndex(index));
            return;
        }

        return;
    }

    


    private int bubbleDown( int index) {
        if(size == 1){
            return 0;
        }

        if(leftChild(index) == null && rightChild(index) ==null)
            return index;
        else if(leftChild(index) != null && rightChild(index) ==null){
                swap(leftChildIndex(index),index);
                return index;                
        }
        else if(leftChild(index) != null && rightChild(index) !=null){
            if(leftChild(index).key < rightChild(index).key){
                swap(leftChildIndex(index),index);
                indexSearch = bubbleDown(leftChildIndex(index));
            }         
            else{
                swap(rightChildIndex(index),index);
                indexSearch = bubbleDown(rightChildIndex(index));
            }
        }

        return indexSearch;

    }

    private Node isParent(int index) {
        return arrayNodes[isParentIndex(index)];
    }

    private int isParentIndex(int index) {
        return (index-1)/2;
    }

    private Node rightChild(int index) {
        return arrayNodes[rightChildIndex(index)];
    }


    private Node leftChild(int index) {
        return arrayNodes[leftChildIndex(index)];
    }

    private void swap(int first, int second){
        aux = arrayNodes[first];
        arrayNodes[first] = arrayNodes[second];
        arrayNodes[second] = aux;     
    }

    private int leftChildIndex(int index) {
        return 2*index + 1;
    }

    private int rightChildIndex(int index) {
        return 2*index + 2;
    }



    private class Node{
        public String value;
        public int key;

        public Node(int key, String value){
            this.key=key;
            this.value=value;
        }
    }

}
