package DataStructure.NonLinearStructures;

public class Main {
    public static void main(String[] args){
        int[] array = {10, 5, 15 , 6, 1, 8, 12, 18, 17};
        BinaryTree binaryTree = new BinaryTree(array);
        //BinaryTree binaryTree2 = new BinaryTree(array);

        binaryTree.insert(2);
        binaryTree.insert(3);
        binaryTree.insert(0);
        binaryTree.insert(7);
        binaryTree.getTree();
        System.out.println(binaryTree.find(10));
        System.out.println(binaryTree.getAncestor(11).toString());
    }
    
    //recursion
    public static int factorial(int n){
        //Base condition
        if(n==0)
            return 1;
        
        return n * factorial(n-1);
    }
}
