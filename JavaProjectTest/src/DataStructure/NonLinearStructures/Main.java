package DataStructure.NonLinearStructures;

//import DataStructure.NonLinearStructures.FunctionWithStructures.MinHeapNodes;
//import DataStructure.NonLinearStructures.FunctionWithStructures.Heapify;
//import DataStructure.NonLinearStructures.FunctionWithStructures.SortHeap;

public class Main {
    public static void main(String[] args) {
        // int[] array = {10, 5, 15 , 6, 1, 8, 12, 18, 17};
        // String[] words ={"message"};
        // BinaryTree binaryTree = new BinaryTree(array);
        // BinaryTree binaryTree2 = new BinaryTree(array);
        // AVLTree avlTree = new AVLTree();
        // MinHeapNodes heap = new MinHeapNodes();
        // Trie trie = new Trie();
        // Graph graph = new Graph();
        WeightedGraph graph = new WeightedGraph();
        /*
         * graph.addNode("yellow"); graph.addNode("blue"); graph.addNode("red");
         * graph.addNode("green"); graph.addNode("diamond"); graph.addNode("nimble");
         * graph.addNode("holistic"); graph.addNode("white");
         */
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");

        graph.addEdge("A", "B", 3);
        graph.addEdge("A", "C", 1);
        graph.addEdge("C", "D", 5);
        graph.addEdge("B", "C", 2);
        graph.addEdge("B", "D", 4);

        /*
         * graph.addEdge("blue", "yellow", 2); graph.addEdge("red", "blue", 3);
         * graph.addEdge("blue", "green", 5); graph.addEdge("yellow", "green", 7);
         * graph.addEdge("yellow", "holistic", 10); graph.addEdge("green", "diamond",
         * 4); graph.addEdge("green", "holistic", 4); graph.addEdge("green", "nimble",
         * 3); graph.addEdge("white", "holistic", 1); graph.addEdge("white", "diamond",
         * 3);
         */
        graph.PrimAlgorithm();
        graph.print();

    }

    // recursion
    public static int factorial(int n) {
        // Base condition
        if (n == 0)
            return 1;

        return n * factorial(n - 1);
    }
}
