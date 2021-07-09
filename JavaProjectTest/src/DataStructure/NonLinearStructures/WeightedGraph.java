package DataStructure.NonLinearStructures;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class WeightedGraph {
    Map<String, Node> mapNode = new HashMap<>();

    public void addNode(String value) {

        mapNode.putIfAbsent(value, new Node(value));

    }

    public void addEdge(String from, String to, int weight) {
        if (mapNode.get(from) == null)
            throw new IllegalArgumentException();

        if (mapNode.get(to) == null)
            throw new IllegalArgumentException();

        // undirect graph
        mapNode.get(from).addEdge(mapNode.get(to), weight);
        mapNode.get(to).addEdge(mapNode.get(from), weight);

    }

    public void print() {
        for (var nodes : mapNode.values())
            if (!nodes.getEdges().isEmpty())
                System.out.println(nodes + " is connected to " + nodes.getEdges());
    }

    public void PrimAlgorithm() { // transform graph in tree
        if (mapNode.values().isEmpty())
            return;

        var node = mapNode.values().iterator().next();
        var tree = new WeightedGraph();
        List<Node> containsNode = new ArrayList<>();
        PriorityQueue<NodeEntry> pqueue = new PriorityQueue<>(Comparator.comparingInt(nodeEntry -> nodeEntry.priority));

        tree.addNode(node.value);
        PrimAlgorithm(node, containsNode, pqueue, tree);

        tree.print();
    }

    private void PrimAlgorithm(Node node, List<Node> containsNode, PriorityQueue<NodeEntry> pqueue,
            WeightedGraph tree) {
        pqueue.clear();

        containsNode.add(node);

        for (var edge : node.mapEdge)
            if (!containsNode.contains(edge.to))
                pqueue.add(new NodeEntry(edge.to, edge.weight));

        if (!pqueue.isEmpty()) {
            tree.addNode(pqueue.peek().node.value);
            tree.addEdge(node.value, pqueue.peek().node.value, pqueue.peek().priority);
            PrimAlgorithm(pqueue.poll().node, containsNode, pqueue, tree);
        } else
            return;

    }

    public boolean hasCycle() {
        Set<Node> visited = new HashSet<>();
        Map<Node, Node> parent = new HashMap<>();
        boolean cycle = false;

        for (var node : mapNode.values()) {
            if (!visited.contains(node)) {
                cycle = hasCycle(node, visited, parent, cycle);
            }
        }

        return cycle;

    }

    private boolean hasCycle(Node node, Set<Node> visited, Map<Node, Node> parent, boolean cycle) {
        visited.add(node);

        for (var edge : node.mapEdge) {
            parent.put(edge.to, edge.from);
            if (!parent.containsValue(edge.to) && !cycle) {
                if (!visited.contains(edge.to))
                    cycle = hasCycle(edge.to, visited, parent, cycle);
                else
                    cycle = true;
            }
        }

        return cycle;

    }

    public List<String> getShortestPath(String from, String to) {
        PriorityQueue<NodeEntry> pqueue = new PriorityQueue<>(Comparator.comparingInt(nodeEntry -> nodeEntry.priority));
        Map<Node, Integer> mapDistance = new HashMap<>();
        Map<Node, Node> mapPrevious = new HashMap<>();
        List<Node> containsNode = new ArrayList<>();
        List<String> path = new ArrayList<>();

        if (mapNode.get(from) == null)
            throw new IllegalArgumentException();

        if (mapNode.get(to) == null)
            throw new IllegalArgumentException();

        for (var node : mapNode.values()) {
            mapDistance.put(node, Integer.MAX_VALUE / 2);
        }
        mapDistance.put(mapNode.get(from), 0);

        getShortestPath(mapNode.get(from), pqueue, mapDistance, mapPrevious, containsNode);
        ShortestPathList(mapNode.get(from), mapNode.get(to), mapPrevious, path);

        return path;

        // return mapDistance.get(mapNode.get(to));// --> can be used to return the
        // integer distance from initial node

    }

    private void ShortestPathList(Node from, Node to, Map<Node, Node> mapPrevious, List<String> path) {

        while (!to.equals(from)) {
            ShortestPathList(from, mapPrevious.get(to), mapPrevious, path);
            path.add(to.value);
            return;
        }

        path.add(from.value);
        return;
    }

    private void getShortestPath(Node node, PriorityQueue<NodeEntry> pqueue, Map<Node, Integer> mapDistance,
            Map<Node, Node> mapPrevious, List<Node> containsNode) {

        if (!containsNode.contains(node)) {
            for (var edge : node.mapEdge) {
                if (mapDistance.get(edge.to) > edge.weight + mapDistance.get(edge.from)
                        && !containsNode.contains(edge.to)) {
                    mapDistance.put(edge.to, edge.weight + mapDistance.get(edge.from));
                    mapPrevious.put(edge.to, edge.from);
                    pqueue.add(new NodeEntry(edge.to, edge.weight));
                }
            }

            containsNode.add(node);
        }

        while (!pqueue.isEmpty())
            getShortestPath(pqueue.poll().node, pqueue, mapDistance, mapPrevious, containsNode);
    }

    private class NodeEntry {
        private Node node;
        private int priority;

        public NodeEntry(Node node, int priority) {
            this.node = node;
            this.priority = priority;
        }
    }

    private class Node {
        public String value;
        private List<Edge> mapEdge = new ArrayList<>();

        public Node(String value) {
            this.value = value;
        }

        public void addEdge(Node to, int weight) {
            mapEdge.add(new Edge(this, to, weight));
        }

        public List<Edge> getEdges() {
            return mapEdge;
        }

        @Override
        public String toString() {
            return this.value;
        }

    }

    private class Edge {
        public Node from;
        public Node to;
        public int weight;

        public Edge(Node from, Node to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return from + "->" + to;
        }
    }
}
