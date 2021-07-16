package DataStructure.NonLinearStructures;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
    public Node node;
    public Node root; 

    public BinaryTree(int[] array){
        
        node = new Node(array[0]);
        root = node;
            
        for(int i = 1; i<array.length; i++){
            node = root;
            int number = array[i];
            insert(number);
        }     
    }
    
    public boolean find(int number){
        node = root;

        while(true){
            if (node.getNodeValue() == number)
                return true;
            if(node.getNodeValue()> number){
                if(node.getLeftNode == null){
                    return false;
                }
                else{
                    node = node.getLeftNode;
                    if(node.getNodeValue() == number)
                        return true;
                }           
            }
            else{
                if(node.getRightNode == null){
                    return false;
                }
                else{
                    node = node.getRightNode;
                    if(node.getNodeValue() == number)
                        return true;
                }               
            }   
        } 
    }

    public void insert(int number){
        node = root;

        while(true){
            if(node.getNodeValue()> number){
                if(node.getLeftNode == null){
                    node.setLeftNode(new Node(number));
                    return;
                }
                else{
                    node = node.getLeftNode;
                }           
            }
            else{
                if(node.getRightNode == null){
                    node.setRightNode(new Node(number));
                    return;
                }
                else{
                    node = node.getRightNode;
                }               
            }   
        } 
    }

    public Node getTree(){
        return root;
    }

    // Different ways of navigating through a tree
    public void traversePreOrder(){ // Root/left/right
        traversePreOrder(root);
    }

    public void traverseInOrder(){ // Root/left/right
        traverseInOrder(root);
    }

    public void traversePostOrder(){ // Root/left/right
        traversePostOrder(root);
    }

    private void traversePreOrder(Node root){ // Root/left/right
        if(root == null)
            return;
            
        System.out.println(root.getNodeValue());
        traversePreOrder(root.getLeftNode);
        traversePreOrder(root.getRightNode);

    }

    private void traverseInOrder(Node root){ // left/root/right
        if(root == null)
            return;
            
        traverseInOrder(root.getLeftNode);
        System.out.println(root.getNodeValue());
        traverseInOrder(root.getRightNode);

    }

    private void traversePostOrder(Node root){ // left/right/Root
        if(root == null)
            return;
            
        traversePostOrder(root.getLeftNode);
        traversePostOrder(root.getRightNode);
        System.out.println(root.getNodeValue());

    }
    // height and min public methods
    public int height(){
        return height(root);
    }

    public int min(){
        return min(root);
    }

    // height of tree
    private int height(Node root){
        if(root == null)
            return -1;

        if(root.getLeftNode == null && root.getRightNode == null)
            return 0;
        
        return 1 +Math.max(height(root.getLeftNode),height(root.getRightNode)); 
    }

    // min value for a binary search tree
    public int minSearchTree(){ // O(log(n))
        if(root == null)
            throw new IllegalStateException();

        var current = root;
        var last = current;
        while(current != null){
            last = current;
            current = current.getLeftNode;
        }
        
        return last.getNodeValue();
    }

    
    // min value for a tree
    private int min(Node root){ // for binary tree O(n) --> if it is a binary search tree there is a less expensive way because all value to the left are less than the root
                                // and the values to right are bigger, so you can divide your tree and search in O(log n)
        int left;
        int right;
        if(root.getLeftNode == null && root.getRightNode == null)
            return root.getNodeValue();           
        else if(root.getLeftNode != null && root.getRightNode == null){
             left = min(root.getLeftNode);
             right = Integer.MAX_VALUE;
        }
        else if(root.getLeftNode == null && root.getRightNode != null){
             left = Integer.MAX_VALUE;
             right = min(root.getRightNode);
        }
        else{
             left = min(root.getLeftNode);
             right = min(root.getRightNode);
        }

        return Math.min(Math.min(left, right), root.getNodeValue());
    }

    // check if two trees are equal
    public boolean equalsTree(BinaryTree tree){
        if(tree == null)
            return false;

        return equalsTree(root, tree.root);
    }

    private boolean equalsTree(Node root, Node rootCompare){
        if(root == null && rootCompare == null)
            return true;
    
        if(root != null && rootCompare !=null)
            return root.getNodeValue() == rootCompare.getNodeValue() &&
                   this.equalsTree(root.getLeftNode, rootCompare.getLeftNode) && 
                   this.equalsTree(root.getRightNode, rootCompare.getRightNode);

        return false;
    }
    
    // Check if is a binary search tree
    public boolean isBinarySearchTree(){
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        return isBinarySearchTree(root, min, max);
    }

    private boolean isBinarySearchTree(Node root, int min, int max){
        if(root == null)
            return true;

        if(root.getNodeValue() > max || root.getNodeValue() < min)
            return false;
        
        return   
                isBinarySearchTree(root.getLeftNode, min, root.getNodeValue() - 1)
                && isBinarySearchTree(root.getRightNode, root.getNodeValue() + 1, max);
    }
    
    //Distance at k node
    public void kDistanceNodes(int distance){
        kDistanceNodes(root, distance);
    }

    private void kDistanceNodes(Node root, int distance){
        if(root == null){
            return;
        }

        if(distance == 0){
            System.out.println(root.getNodeValue());
            return;
        }

        distance--;

        kDistanceNodes(root.getLeftNode, distance);
        kDistanceNodes(root.getRightNode, distance);
    }

    // traverse Breadth
    public void traverseLevelOrder(){
        for(var i = 0; i< height(); i++)
            kDistanceNodes(i);
    }


    //Tree size
    public int size(){
        return size(root, 0);
    }

    private int size(Node root, int size){
        if (root == null)
            return 0;
        
        else
            size = 1;

        return size + size(root.getLeftNode, size) + size(root.getRightNode,size); 
    }

    //Tree count leaves

    public int countLeaves(){
        return countLeaves(root);
    }

    private int countLeaves(Node root){
        if (root == null)
            return 0;

        if (root.getLeftNode == null && root.getRightNode == null)
            return 1;
        
        return countLeaves(root.getLeftNode) + countLeaves(root.getRightNode); 
    }

    //Tree max
    public int max(){
        return max(root);
    }

    private int max(Node root){
        int left;
        int right;

        if(root.getLeftNode == null && root.getRightNode == null)
            return root.getNodeValue();           
        else if(root.getLeftNode != null && root.getRightNode == null){
             left = max(root.getLeftNode);
             right = Integer.MIN_VALUE;
        }
        else if(root.getLeftNode == null && root.getRightNode != null){
             left = Integer.MIN_VALUE;
             right = max(root.getRightNode);
        }
        else{
             left = max(root.getLeftNode);
             right = max(root.getRightNode);
        }

        return Math.max(Math.max(left, right), root.getNodeValue());
        
    }

    public int maxBinarySearchTree(Node root){
        if (root == null)
            return -1;

        if (root.getRightNode == null)
            return root.getNodeValue();

        return maxBinarySearchTree(root.getRightNode);           
    }
     
    //Tree Contains
    public boolean contains(int number){
        return contains(root, number);
    }
    private boolean contains(Node root, int number){
        if (root==null){
            return false;
        }

        if(root.getNodeValue() == number){
            return true;
        }

        return contains(root.getLeftNode,number) || contains(root.getRightNode,number);
    }

    //Tree siblings
    public boolean siblings(int number, int number2){
        if (root==null)
            return false;
        return siblings(root, number, number2);
    }

    private boolean siblings(Node root, int number, int number2){
        if(root.getLeftNode==null || root.getRightNode == null){
            return false;
        }
        else if((root.getLeftNode.getNodeValue() == number && root.getRightNode.getNodeValue() == number2) ||
                (root.getLeftNode.getNodeValue() == number2 && root.getRightNode.getNodeValue() == number))
                return true;
        
        return siblings(root.getLeftNode, number, number2) || siblings(root.getRightNode, number, number2);

    }

    //Tree get ancestors
    public List<Integer> getAncestor(int number){
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        getAncestor(root, number, list, list2);
        return list2;
    }
    public void getAncestor(Node root, int number, List<Integer> list, List<Integer> list2){
        if(root==null){           
            return;
        }
        
        if(root.getNodeValue() != number){
            list.add(root.getNodeValue());
            getAncestor(root.getLeftNode, number, list, list2);
            getAncestor(root.getRightNode, number, list, list2);
            list.remove(list.size()-1);
        }
        else{
            list.forEach( x -> list2.add(x));
        }
            
        
        

    }

    //Node Class
    private class Node{
        private int number;
        public Node getLeftNode;
        public Node getRightNode;
    
        public Node(int number){
            this.number = number;
        }

        public int getNodeValue(){
            return number;
        }

    
        public void setLeftNode(Node next){
            this.getLeftNode = next;
        }

    
        public void setRightNode(Node next){
            this.getRightNode = next;
        }

           
    }
}


