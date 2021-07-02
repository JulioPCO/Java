package DataStructure.NonLinearStructures;

import DataStructure.NonLinearStructures.FunctionWithStructures.MinHeapNodes;
//import DataStructure.NonLinearStructures.FunctionWithStructures.Heapify;
import DataStructure.NonLinearStructures.FunctionWithStructures.SortHeap;

public class Main {
    public static void main(String[] args){
        int[] array = {10, 5, 15 , 6, 1, 8, 12, 18, 17};
        //BinaryTree binaryTree = new BinaryTree(array);
        //BinaryTree binaryTree2 = new BinaryTree(array);
        //AVLTree avlTree = new AVLTree();
        MinHeapNodes heap = new MinHeapNodes();
        heap.insert(15,"a");
        heap.insert(12,"b");
        heap.insert(13,"c");
        heap.insert(6,"d");
        heap.insert(7,"e");
        heap.insert(8,"f");
        heap.insert(9,"g");
        heap.remove();
        

        
        //Heapify heapify = new Heapify();
        var isMaxHeap =new  SortHeap();
        System.out.println(isMaxHeap.isMaxHeap(array));
        
    }
    
    //recursion
    public static int factorial(int n){
        //Base condition
        if(n==0)
            return 1;
        
        return n * factorial(n-1);
    }
}
