package DataStructure.NonLinearStructures;

public class Main {
    public static void main(String[] args){
        //int[] array = {10, 5, 15 , 6, 1, 8, 12, 18, 17};
        //BinaryTree binaryTree = new BinaryTree(array);
        //BinaryTree binaryTree2 = new BinaryTree(array);

        AVLTree avlTree = new AVLTree();

        avlTree.insert(10);
        avlTree.insert(5);
        avlTree.insert(4);
        avlTree.insert(13);
        avlTree.insert(14);
        avlTree.insert(12);
        avlTree.insert(6);

        System.out.println(avlTree.isPerfect());
    }
    
    //recursion
    public static int factorial(int n){
        //Base condition
        if(n==0)
            return 1;
        
        return n * factorial(n-1);
    }
}
