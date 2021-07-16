package DataStructure.NonLinearStructures;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.Map.Entry;

public class Graph {
    private Map<String, Node> nodes = new HashMap<String, Node>();
    private Map<Node, List<Node>> edges = new HashMap<>();    
    public void addNode(String label){
        
        var node = new Node(label);
        nodes.putIfAbsent(label, node);
        edges.putIfAbsent(node, new ArrayList<>());
        
        
    }

    public void addEdge(String from, String to){
         Node fromNode = nodes.get(from);
        if(fromNode == null)
            throw new IllegalArgumentException();

        Node toNode = nodes.get(to);
        if(toNode == null)
            throw new IllegalArgumentException();

        edges.get(fromNode).add(toNode);
    }

    public void print(){
        for(var nodes: edges.keySet())
            if(!edges.get(nodes).isEmpty())
                System.out.println(nodes + " is connected to " + edges.get(nodes));
    }

    
    public void removeNode(String label){
        var nodeErase = nodes.get(label);
        if (nodeErase == null)
            return;

        if (nodes.containsKey(label)){
            //erase edge associated with the label            
            edges.get(nodeErase).clear();
            edges.remove(nodeErase);

            //erase node from other edges
            for (var node : edges.keySet())
                edges.get(node).remove(nodeErase);

            //remove node
            nodes.remove(label);   
        }
        else 
            System.out.println("label not found");

        System.out.println("Done");
    }

    
    public void depthFirstTraversalIterative(String label){
        Set<String> setIterative = new HashSet<>();
        Stack<Node> stack = new Stack<>();

        var first = nodes.get(label);
        if(first == null)
            return;

        stack.add(first);

        while(!stack.isEmpty()){
            var current = stack.pop();

            if(setIterative.contains(current.label))
                continue;
            
            System.out.println(current.label);
            setIterative.add(current.label);

            for (var link : edges.get(current)){
                stack.add(link);             
            }
        }

    }

    public void breadthFirstTraversalIterative(String label){
        Queue<Node> queue = new ArrayDeque<>();
        Set<String> setIterative = new HashSet<>();

        var first = nodes.get(label);
        if(first == null)
            return;

        queue.add(first);

        while(!queue.isEmpty()){
            var current = queue.remove();

            if(setIterative.contains(current.label))
                continue;

            System.out.println(current.label);
            setIterative.add(current.label);

            for (var link : edges.get(current)){
                queue.add(link);             
            }
        }

    }

    public void depthFirstTraversalRecursion(String label){ 
        Set<String> set = new HashSet<>();         
        var first = nodes.get(label);
        if(first == null)
            return;
        
        depthFirstTraversalRecursion(first, set);

        System.out.println(set.toString());

    }

    private void depthFirstTraversalRecursion(Node node, Set<String> set){
        
        if(!set.contains(node.label))
            System.out.println(node.label);
        
        set.add(node.label);

        if(edges.get(node).isEmpty())
            return;

        for (var link : edges.get(node)){
            depthFirstTraversalRecursion(link,set);
        }


    }

    public List<String> topologicalSort(){ 
        List<String> list = new ArrayList<>();
        Stack<String> stack = new Stack<>();         
        
        for(var node : nodes.values())
            topologicalSort(node, stack);

        while(!stack.isEmpty())
            list.add(stack.pop());

        return list;

    }

    private void topologicalSort(Node node, Stack<String> list){
        if(edges.get(node).isEmpty()){
            if(!list.contains(node.label)){
                System.out.println(node.label);
                list.add(node.label);
            }
            return;
        }

        for (var link : edges.get(node)){
            topologicalSort(link,list);
      
        }

        if(!list.contains(node.label)){
            System.out.println(node.label);
            list.add(node.label);
        }


    }

    public boolean hasCycleSolution(){
        Set<Node> all = new HashSet<>();
        Set<Node> visiting = new HashSet<>();
        Set<Node> visited = new HashSet<>();

        all.addAll(nodes.values());

        while(!all.isEmpty()){
            var current = all.iterator().next();
            if(hasCycleSolution(current,all,visiting, visited))
                return true;
        }

        return false;
    }

    private boolean hasCycleSolution(Node node, Set<Node> all, Set<Node> visiting, Set<Node> visited){
        all.remove(node);
        visiting.add(node);

        for(var neighbour: edges.get(node)){
            if(visited.contains(neighbour))
                continue;

            if(visiting.contains(neighbour))
                return true;

            if(hasCycleSolution(neighbour,all,visiting,visited))
                return true;
            
        }

        visiting.remove(node);
        visited.add(node);

        return false;
    }

    public boolean hasCycle(){
        Map<String, Node> all = new Hashtable<>();
        Map<String, Node> visited = new Hashtable<>();
        Map<String, Node> visiting = new Hashtable<>();

        for (var node : nodes.values()){
            all.put(node.label, node);
        }

        for(var key: nodes.entrySet()){
            if(!visited.containsKey(key.getKey())){
                Node keySave = key.getValue();
                changingNodes(visiting, all, key.getValue());

                visitingValue(all, visited, visiting, keySave);
            }

        }
        
        if(all.isEmpty())
            return false;
        else
            return true;

    }

    private void visitingValue(Map<String, Node> all, Map<String, Node> visited, Map<String, Node> visiting,
            Node key) {
        for (var link : edges.get(key)){
            if(edges.get(link).isEmpty()){
                changingNodes(visited, all, link);               
            }
            else{
                if(!visiting.containsKey(link.label)){
                    changingNodes(visiting, all, link);
                    visitingValue(all, visited, visiting, link);
                    changingNodes(visited, visiting, link);
                }
                
                if(visiting.containsKey(link.label)){
                    changingNodes(all, visiting, link);
                }
            }
        }

        if(!visited.containsKey(key.label)){
            changingNodes(visited, visiting, key);
        }

    }

    private void changingNodes(Map<String, Node> first, Map<String, Node> second,  Node key) {
        first.put(key.label,key);
        second.remove(key.label);
    }

    private class Node{
        public String label;

        public Node(String label){
            this.label = label;
        }

        @Override
        public String toString(){
            return this.label;
        }
    }
    
}
