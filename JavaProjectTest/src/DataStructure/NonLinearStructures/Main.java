package DataStructure.NonLinearStructures;

import DataStructure.NonLinearStructures.FunctionWithStructures.Heapify;
//import DataStructure.NonLinearStructures.FunctionWithStructures.SortHeap;

public class Main {
    public static void main(String[] args){
        int[] array = {10, 5, 15 , 6, 1, 8, 12, 18, 17};
        //BinaryTree binaryTree = new BinaryTree(array);
        //BinaryTree binaryTree2 = new BinaryTree(array);
        //AVLTree avlTree = new AVLTree();
        Heap heap = new Heap(20);
        heap.insert(5);
        heap.insert(10);
        heap.insert(12);
        heap.insert(0);
        heap.insert(8);
        heap.insert(16);
        heap.insert(-1);
        System.out.println(heap.remove(16));
        System.out.println(heap.toString());

        Heapify heapify = new Heapify();
        var heapified = heapify.heapify(array);
        System.out.println(heapified);
        
    }
    
    //recursion
    public static int factorial(int n){
        //Base condition
        if(n==0)
            return 1;
        
        return n * factorial(n-1);
    }
}
