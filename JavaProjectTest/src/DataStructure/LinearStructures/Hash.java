package DataStructure.LinearStructures;


import java.util.Iterator;
import java.util.LinkedList;


public class Hash {
    //simple Hash
    public int hashString(String key){
        int hash = 0;

        for (char ch : key.toCharArray())
            hash += ch; // convert ch to it integer number and add in the hash

        return hash % 100; // imaginary vector with length = 100
    }

    // collisions -> when two keys have the same hash values
    // 2 ways to solve -> chaining-> using linked list to link the repeated hash values
    //                 -> open adressing -> find new adress for second value : linear probing, quadratic probing, double hashing

    // linear probing -> can create cluster (cell filled with data together):(if hash(key) is not available) -> (hash(key)+i)%table_size 
    // quadratic probing-> avoid cluster but can occur infinite loops: (hash(key)+i^2)%table_size
    // double hashing-> use a second hash function to calculate where to fill the data: e.g hash2(key) = prime - (key%prime) -> prime smaller than table size
    //                                                                                      (hash1(key) + i*hash2(key)%table_size)


    // Exercise
    //HashTable, .put(k,v), .get(k), .remove(k), k:int, v:string, Collision: chaining
    private int hashInt(int key){
        return key % link.length; // imaginary vector with length = 100
    }

    @SuppressWarnings("unchecked") LinkedList<Entry>[] link = new LinkedList[100];
    Iterator<Entry> iterator;
    
    public void put(int k, String v){ 
        int hash = hashInt(k);
        
        if(link[hash]==null)
            link[hash] = new LinkedList<>();
        
        for(Entry entry : link[hash]){ // nice feature didn't know
            if(entry.getK() == k){
                entry.setV(v); // avoid adding same key value to hash map
                return;
            }
        }

        Entry data = new Entry(k, v);
        link[hash].add(data);       
    }

    public String get(int k){
        int hash = hashInt(k);
        String v = "";

        if(link[hash]==null)
            return v="null";

        for(int i = 0; i< link[hash].size(); i++){  
            if( k == link[hash].get(i).getK()){
                v = link[hash].get(i).getV();
                break;
                }            
        }

        return v;
    }
    
    public String remove(int k){
        int hash = hashInt(k);
        String v = "No index";

        if(link[hash]==null)
            return v="null";

        for(int i = 0; i< link[hash].size(); i++){            
            if( k == link[hash].get(i).getK()){
                v = link[hash].get(i).getV();
                link[hash].remove(i);
                break;
            }           
        }

        return v;
    }


    //HashTable, .put(k,v), .get(k), .remove(k), k:int, v:string, Collision: linearProbing
    Entry[] list = new Entry[10];
    int size = 0;

    public void putLinearProbing(int key, String value){
        
        int hash = hashInt(key); // supposing only keys>0

        if(list[hash] == null){
            list[hash] = new Entry(key, value); // add value if hash is empty
            size++;
            return;           
        }
        else{
            setIndexLinearProbing(hash, key, value);           
        }       
    }

     public String getLinearProbing(int key){
        int hash = hashInt(key);

        if(list[hash].getK() == key)
            return list[hash].getV();
        else{
            return list[getIndexLinearProbing(hash, key)].getV();
        }
    }

    public void removeLinearProbing(int key){
        int hash = hashInt(key);

        if(list[hash].getK() == key){
             list[hash] = null;
             size--;
             return;
        }
        else{
            list[getIndexLinearProbing(hash, key)] = null;
            size--;

        }       
    } 

    private int getIndexLinearProbing(int hash, int key){
        int sizeVerifier=0;

        while(!(list[hash] != null) || (sizeVerifier != size)){
            if(list[hash] != null){    
                if(list[hash].getK() == key ){ // get value if key already exist     
                    return hash;
                }
    
                hash = increasingCircularArray(hash);
                sizeVerifier++;
            }
            else{
                hash = increasingCircularArray(hash);
            }
            
        }

        throw new IllegalStateException();
    }

    private int increasingCircularArray(int hash) {
        if(hash == list.length-1) // circular array
            hash = -1;
            
        hash = hash+1;
        return hash;
    }

    private void setIndexLinearProbing(int hash, int key, String value){
        int count =  0;

        while(list[hash] != null){
            if(count > list.length){ // see if the map is full
                throw new IllegalStateException();
            }

            if(list[hash].getK() == key ){ // get value if key already exist     
                list[hash].setV(value);
                return;
            }

            hash = increasingCircularArray(hash);
            count++;
        }
        
        list[hash] = new Entry(key, value); // add new value in a new hash if original hash is not empy 
        size++;
    }

    public int sizeLinearProbing(){
        return size;
    }
}
