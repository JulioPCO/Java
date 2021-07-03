package DataStructure.NonLinearStructures;

//import DataStructure.NonLinearStructures.FunctionWithStructures.MinHeapNodes;
//import DataStructure.NonLinearStructures.FunctionWithStructures.Heapify;
//import DataStructure.NonLinearStructures.FunctionWithStructures.SortHeap;

public class Main {
    public static void main(String[] args){
        int[] array = {10, 5, 15 , 6, 1, 8, 12, 18, 17};
        String[] words ={"message"};
        //BinaryTree binaryTree = new BinaryTree(array);
        //BinaryTree binaryTree2 = new BinaryTree(array);
        //AVLTree avlTree = new AVLTree();
        //MinHeapNodes heap = new MinHeapNodes();
        Trie trie = new Trie();
    }
    
    //recursion
    public static int factorial(int n){
        //Base condition
        if(n==0)
            return 1;
        
        return n * factorial(n-1);
    }
}
