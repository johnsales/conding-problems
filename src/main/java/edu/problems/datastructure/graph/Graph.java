package edu.problems.datastructure.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Graph {

    private HashMap<Integer, Node> nodeLookup = new HashMap<>();

    public static class Node {
        private int id;
        LinkedList<Node> adjacent = new LinkedList<>();
        private Node(int id){
            this.id = id;
        }
    }

    private Node getNode(int id){
        //todo
        return null;
    }

    public void addEdge(int source, int destination){
        Node s = getNode(source);
        Node d = getNode(destination);
        s.adjacent.add(d);
    }

    public boolean hasPathDFS(int source, int destination){
        Node s = getNode(source);
        Node d = getNode(destination);
        HashSet<Integer> visited = new HashSet<>();
        return hasPathDFS(s,d,visited);
    }

    //main code
    public boolean hasPathDFS(Node source, Node destination, HashSet<Integer> visited) {
        if(visited.contains(source.id)){
            return false;
        }
        visited.add(source.id);
        if(source == destination){
            return true;
        }
        for (Node child :source.adjacent) {
            if(hasPathDFS(child, destination, visited)){
                return true;
            }
        }
        return false;
    }

    public boolean hasPathBFS(int source, int destination){
        return hasPathBFS(getNode(source), getNode(destination));
    }

    //main code
    public boolean hasPathBFS(Node source, Node destination) {
        LinkedList<Node> nextToVisit = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        nextToVisit.add(source);

        while(!nextToVisit.isEmpty()){
            Node node = nextToVisit.remove();
            if(node == destination) return true;
            if(visited.contains(node.id)) continue;
            visited.add(node.id);
            nextToVisit.addAll(node.adjacent);
        }
        return false;
    }
}