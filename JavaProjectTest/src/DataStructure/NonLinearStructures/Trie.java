package DataStructure.NonLinearStructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Trie {
    private static int AlphabetSize = 26;
    private int index;
    private Node node= new Node('\u0000');
    private Node current;

    public void insert(String word){
        current = node;

        for(char ch : word.toCharArray()){
            index = ch - 'a';

            if(current.nextNode[index] == null)
                current.nextNode[index] = new Node(ch);
                      
            current = current.nextNode[index];

        }

        current.isEndOfWord = true;
    }

    public boolean contains(String word){
        if(word == null){
            throw new IllegalArgumentException();
        }

        current = node;

        for(char ch : word.toCharArray()){
            index = ch - 'a';

            if(current.nextNode[index] == null){
                return false;
                
            }
                      
            current = current.nextNode[index];
        }

        if(current.isEndOfWord)
            return true;

        return false;
    }

    public boolean containsReverse(String word){
        if(word == null)
            return false;

        boolean contain;
        int count = 0;
        contain = containsReverse(node, word, count);
        return contain;
    }

    private boolean containsReverse(Node node,String word, int count){
        if(count == word.length() && node.isEndOfWord)
            return true;

        if(count == word.length() && !node.isEndOfWord)
            return false;

        boolean contain;
        if(node.nextNode[indexOfCount(word, count)] != null){
            node = node.nextNode[indexOfCount(word, count)];
            contain = true;
            count++;
            return contain && containsReverse(node, word, count);
        }
        else{
            contain = false;
            return contain;
        }
    }

    public void traverse(){
        traverse(node);
    }

    private void traverse(Node node){
        if(node == null)
            return;

        //Pre-order traversal -> visit the root first
        /* if(node != null)
            System.out.println(node.toString()); */
        
        for(Node child: node.nextNode)
            traverse(child);

        //Post-order traversal -> visit root last
        if(node != null)
            System.out.println(node.toString());
        
    }

    public void remove(String word){
        if(word == null)
            return;

        int count = 0;
        if(this.contains(word)){    
            remove(node, word, count);

            //removing first letter node if this letter has no child
            if(node.nextNode[indexOfCount(word, count)].isEmpty()) 
                node.nextNode[indexOfCount(word, count)]=null;

        }
        else
            System.out.println("Word not found");
           
        
    }

    private void remove(Node current, String word, int count){
        //get index of word to remove
        index = indexOfCount(word, count);

        // verify if the last character has childrens or not -> if does we don't erase anything just set isEndOfWord to false;
        if(count >= word.length()-1 && current.nextNode[index].isEmpty() == true){
            current.nextNode[index] = null;
            return;
        }else if(count >= word.length()-1){
            current.nextNode[index].isEndOfWord=false;
            return;
        }
  
        count++;

        //get next node
        current = current.nextNode[index];
        //recursion
        remove(current, word, count); 

        //get index again
        index = indexOfCount(word, count);
        System.out.println(current.ch);
       
        //Avoid exception on last node of recursion when childrens are empty
        if(current.nextNode[index] == null)
            return;

        //verify if the next node is empty and if the next node is not another word
        if(current.nextNode[index].isEmpty() == true && current.nextNode[index].isEndOfWord == false){
            current.nextNode[index] = null;
            return;        
        }
        
        //At the last recursion, update node at position 0.
        if (count == 1 )
            node.nextNode[indexOfCount(word,0)] = current;
    }

    public List<String> autoCompletion(String word){
        List<String> list = new ArrayList<>();
        if(word == null )
            return list;
        
        current = node;

        // Verify all words
        if(word == ""){
            for(int i=0; i<AlphabetSize; i++){
                int n = 'a' + i;
                char ch = (char) n;
                index = ch - 'a';
                
                autoCompletion(current.nextNode[index], Character.toString(ch).substring(0, word.length()),list);  
            }

            return list;
        }
        
        //autocomplete words written
        for(char ch : word.toCharArray()){
            index = ch - 'a';      
            
            if(current.nextNode[index] == null)
                return list;

            current = current.nextNode[index];
        }

        autoCompletion(current, word.substring(0, word.length()-1), list);

        return list;
    }

    private void autoCompletion(Node node, String word, List<String> list){
        if(node == null)
            return;

        //Pre-order traversal -> visit the root first
        if(node != null)
            word = word + (char) node.ch;
        
        if(node.isEndOfWord == true){
            list.add(word);
        }
            
        for(Node child: node.nextNode)
            autoCompletion(child,word,list);
    }

    public String longestCommonPrefix(String[] words){
        List<String> list = new ArrayList<>();
        String longest;

        //autocomplete words written
        for(String word : words){
            String search = "";
            for(char ch : word.toCharArray()){
                search = search +  ch;      
                
                if(this.contains(search)){
                    list.add(search);
                    break;
                }
                
            }
        }

        if(list.size() != words.length)
            longest ="";
        else{
            if(list.stream().allMatch(name -> name.equals(list.get(0))))
                longest = list.get(0);
            else
                longest = "";
        }

        return longest;
    }


    public int trieCountWords(){
        int number=0;

        var list = autoCompletion("");

        number =(int) list.stream().count();

        return number;
    }

    private int indexOfCount(String word, int count) {
        return word.charAt(count) - 'a';
    }

    public void insertHashTable(String word){  //just for demonstration, in real application we would abstract the currentHashMap.children.get(ch) and 
                                              //currentHashMap.children.put(ch, new Node(ch)) to be changeable.
        var currentHashMap = node;

        for(char ch : word.toCharArray()){
            if(currentHashMap.children.get(ch) == null)
                currentHashMap.children.put(ch, new Node(ch));
                      
            currentHashMap = currentHashMap.children.get(ch);

        }
        currentHashMap.isEndOfWord = true;
        
    }

    private class Node{
        public char ch;
        public Node[] nextNode = new Node[AlphabetSize]; // for Node array implementation
        private HashMap<Character, Node> children = new HashMap<>(); // for hashmap implementation
        public boolean isEndOfWord = false;
        

        public Node(char ch){
             this.ch = ch; 
        }

        public boolean isEmpty(){
            for(Node child :this.nextNode)
                if(child != null)
                    return false;

            return true;
        }

        public void removeChild(int index){
            nextNode[index] = null;
        }

        @Override
        public String toString() {
            return "" + (char) ch;
        }
    }
}
