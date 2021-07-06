package DataStructure.NonLinearStructures;

//import DataStructure.NonLinearStructures.FunctionWithStructures.MinHeapNodes;
//import DataStructure.NonLinearStructures.FunctionWithStructures.Heapify;
//import DataStructure.NonLinearStructures.FunctionWithStructures.SortHeap;

public class Main {
    public static void main(String[] args){
        //int[] array = {10, 5, 15 , 6, 1, 8, 12, 18, 17};
        //String[] words ={"message"};
        //BinaryTree binaryTree = new BinaryTree(array);
        //BinaryTree binaryTree2 = new BinaryTree(array);
        //AVLTree avlTree = new AVLTree();
        //MinHeapNodes heap = new MinHeapNodes();
        //Trie trie = new Trie();
        Graph graph = new Graph();
        graph.addNode("yellow");
        graph.addNode("blue");
        graph.addNode("red");
        graph.addNode("green");
        graph.addNode("diamond");
        graph.addNode("nimble");
        graph.addNode("holistic");

        graph.addEdge("blue", "yellow");
        graph.addEdge("red", "blue");
        graph.addEdge("blue", "green");
        graph.addEdge("yellow", "green");
        graph.addEdge("yellow", "holistic");
        graph.addEdge("green", "diamond");
        graph.addEdge("green", "holistic");
        graph.addEdge("green", "nimble");
        System.out.println(graph.hasCycle()); 
        graph.print();

        
    }
    
    //recursion
    public static int factorial(int n){
        //Base condition
        if(n==0)
            return 1;
        
        return n * factorial(n-1);
    }
}
