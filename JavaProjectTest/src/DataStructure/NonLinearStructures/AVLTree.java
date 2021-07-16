package DataStructure.NonLinearStructures;


public class AVLTree {
    Node root;
    int balanceFactor;

    public void insert(int value){
        //Node node = root;
        root = insert(root, value);
    }

    /* public void insert(Node node, int value){      //My way of this implementation
        if(root == null){
            node = new Node(value);
            root = node;
            return;
        }
        
        if(node.value > value){
            if(node.getLeftNode == null){
                node.getLeftNode = new Node(value);
                return;
            }
            else{
                node = node.getLeftNode;
                insert(node, value);
            }
        }

        if(node.value < value){
            if(node.getRightNode == null){
                node.getRightNode = new Node(value);
                return;
            }
            else{
                node = node.getRightNode;
                insert(node, value);
            }
        }

    } */

    private Node insert(Node root, int value){ // Solution --> same logic as my solution but more compact and less operations. Further methods implemented here
        if(root == null)
            return new Node(value);

        if(value < root.value)
            root.getLeftNode = insert(root.getLeftNode, value);
        else
            root.getRightNode = insert(root.getRightNode,value);

        root.height = heightOfNode(root);

        balanceFactor = balanceFactor(root);
        root = balance(root);

        return root;
    }

    private int heightOfNode(Node root) {
        return Math.max( height(root.getLeftNode),
                                height(root.getRightNode)) + 1;
    }

    private Node balance(Node root) {
        if (balanceFactor > 1){
            if(balanceFactor(root.getLeftNode) < 0){
                root.getLeftNode = leftRotation(root.getLeftNode);
                root = rightRotation(root);
            }     
            else
                root = rightRotation(root);
        }
        else if(balanceFactor < -1){
            if(balanceFactor(root.getRightNode) > 0){
                root.getRightNode = rightRotation(root.getRightNode);
                root = leftRotation(root);
            }
            else
                root = leftRotation(root);
        }

        return root;
    }

    private Node leftRotation(Node root){
        Node newRoot = root.getRightNode;
        if(newRoot.getLeftNode != null)
            root.getRightNode = newRoot.getLeftNode;
        else
            root.getRightNode = null;
        
        newRoot.getLeftNode = root;
        root.height = heightOfNode(root);
        newRoot.height = heightOfNode(newRoot);

        return newRoot;
    }

    private Node rightRotation(Node root){
        Node newRoot = root.getLeftNode;
        if(newRoot.getRightNode != null)
            root.getLeftNode = newRoot.getRightNode;
        else
            root.getLeftNode = null;
        
        newRoot.getRightNode = root;
        root.height = heightOfNode(root);
        newRoot.height = heightOfNode(newRoot);

        return newRoot;
    }

    private int balanceFactor(Node root) {
        return height(root.getLeftNode) - height(root.getRightNode);
    }

    private int height(Node root) {
        return root == null ? -1 : root.height;
    }

    public boolean isBalanced(){
        return isBalanced(root);
    }
    private boolean isBalanced(Node root){
        boolean balanced = false;
        if(root == null)
            return true;

        if (balanceFactor(root) <= 1 && balanceFactor(root) >= -1)
            balanced = true;
        

        return balanced && isBalanced(root.getLeftNode) && isBalanced(root.getRightNode);
    }

    public boolean isPerfect(){
        return isPerfect(root);
    }

    private boolean isPerfect(Node root){
        boolean perfect = false;
        if(root == null)
            return true;
        
        if( root.getLeftNode == null && root.getRightNode == null)
            perfect =  true;
        else if(root.getLeftNode != null && root.getRightNode != null)
                if(root.getLeftNode.height == root.getRightNode.height)
                    perfect = true;
        else
            perfect = false;

        return perfect && isPerfect(root.getLeftNode) && isPerfect(root.getRightNode);
    }

    private class Node{
        public int value;
        public int height = 0;
        public Node getLeftNode;
        public Node getRightNode;

        public Node(int value){
            this.value = value;
        }
        
        @Override
        public String toString(){
            return "value" + this.value;
        }
    }

}
