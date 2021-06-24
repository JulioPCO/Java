package DataStructure.Exercises;

public class Node {
    private int value;
    private Node getNextNode;

    public Node(int value){
        this.value = value;       
    }

    public int getValue() {
        return value;
    }

    public Node getNextNode(){
        return getNextNode;
    }

    public void setNextNode(Node next){
        this.getNextNode = next;
    }
}
