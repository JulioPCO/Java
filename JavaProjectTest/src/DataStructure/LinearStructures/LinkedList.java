package DataStructure.LinearStructures;


public class LinkedList {
    private Node first;
    private Node last;
    private int size;
    public void addFirst(int value){
        if (first == null & last == null)
            first = last = new Node(value);
        else{
            Node node = new Node(value);
            node.setNextNode(first);
            first = node;
        }
        size++;
    }

    public void addLast(int value){
        if (first == null & last == null)
            first = last = new Node(value);
        else{
            Node node = new Node(value);
            last.setNextNode(node);
            last = node;
        }
        size++;
    }

    public void removeLast(){
        ExceptionThrower();
        
        if (first == last){
            first = last = null;
            size--;
            return;  
        }

        Node node = first;
           
        while (node.getNextNode() != last){
            node =  node.getNextNode();
        }
        last = node;
        node.setNextNode(null);
            
        size--;
    }

    public void removeFirst(){
        ExceptionThrower();
        
        if (first == last){
            first = last = null;
            size--;
            return;  
        }
        
        first = first.getNextNode();
        
        size--;
    }

    public boolean contains(int number){
        ExceptionThrower();

        Node node = first;
           
        while (node != null){
            if (node.getValue() == number)
                return true;
            node =  node.getNextNode();
        }

        return false;
    }

    public int indexOf(int number){
        ExceptionThrower();

        int index = 0;
        Node node = first;
           
        while (node != null){
            if (node.getValue() == number)
                return index;
            node =  node.getNextNode();
            index++;
        }

        return -1;   
    }

    private void ExceptionThrower(){
        if (first == null & last == null){
            System.out.println("Empty list");
            throw new IllegalArgumentException();
        }
    }

    public int size(){
        return size;
    }

    public int[] toArray(){
        ExceptionThrower();

        int index = 0;
        Node node = first;
        int[] array = new int[size];

        while (node != null){
            array[index] = node.getValue();
            node =  node.getNextNode();
            index++;
        }
        
        
        return array;
    }

    public void reverse(){
        ExceptionThrower();

        if (first == last){
            return;
        }

        Node node = first;
        int count = 0;
        Node aux = node;
        Node[] store = new Node[size-1]; 

        first = last;

        while (count != size-1){

            if (node.getNextNode() == last){
                node.setNextNode(null); // nullify last node
                last = node; // get last node after the one nullyfied
                store[count] = last;

                if (count>0){
                    store[count-1].setNextNode(store[count]); // create node vector to set nodes in the inverse order
                }

                count++;
                node = aux; // refresh the Node node 
                continue;
            }

            node =  node.getNextNode(); // iteration
            
        }
       
        first.setNextNode(store[0]);
    }

    public void solutionReverse(){
        ExceptionThrower();
        
        var previous = first;
        var current = first.getNextNode();
        while(current != null){
            var next = current.getNextNode();
            current.setNextNode(previous);
            previous=current;
            current = next;
        }

        last = first;
        last.setNextNode(null);
        first = previous;
    }

    public int kthNodeFromTheEnd(int k){        
        // [10 -> 20 -> 30 -> 40]
        // kthNode(1) = 40
        // kthNode(2) = 30

        ExceptionThrower();

        if (k > size || k < 0)
            throw new IllegalArgumentException();
             
        int distance = k;
        var previous = first;
        var next = first;

        while(distance-- > 0)
            next = next.getNextNode();
            /*if (next == null)
                throw new IllegalArgumentException();*/ //if you don't have a size counter 

        while(next != null){
            previous = previous.getNextNode();
            next = next.getNextNode();
        }

        return previous.getValue();
        

    }

    public int[] middleOfList(){
        ExceptionThrower();

        var a = first;
        var b = first;
        int count = 0;
        

        while(b != null){
            if(b == last){
                break;                   
            }
            count++;
            if(count%2 == 0 && count != 0)
                a=a.getNextNode();
            b=b.getNextNode();
        }

        if (count%2 ==0 || count==0){
            int[] value = new int[1];
            value[0] = a.getValue();
            return value;
        }
        else{
            int[] value = new int[2];
            value[0] = a.getValue();
            value[1] = a.getNextNode().getValue();
            return value;
        }

        
        
    }

    public void solutionMiddleOfList(){
        ExceptionThrower();

        var a = first;
        var b = first;

        while (b != last && b.getNextNode() != last) {
            b = b.getNextNode().getNextNode(); 
            a = a.getNextNode();
        }
        if (b == last)
            System.out.println(a.getValue());
        else     
            System.out.println(a.getValue() + "," + a.getNextNode().getValue());
    }

    public boolean hasLoop(){
        ExceptionThrower();

        if (first == last){
            return false;
        }
        
        var a = first;
        var b = first;
        var hasloop = false;

        while(b != null){
            b.getNextNode().getNextNode();
            a.getNextNode();

            if (a==b){
                hasloop=true;
            }
        }

        return hasloop;
    }
}
