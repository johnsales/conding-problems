package edu.problems.algorithms;

import java.util.*;

class Graph {
    private int vertices;
    private List<List<Node>> adj;

    static class Node implements Comparator<Node> {
        private int vertex;
        private int cost;

        public Node() {}

        public Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compare(Node node1, Node node2) {
            return Integer.compare(node1.cost, node2.cost);
        }
    }

    public Graph(int vertices) {
        this.vertices = vertices;
        adj = new ArrayList<>(vertices);

        for (int i = 0; i < vertices; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int dest, int cost) {
        adj.get(source).add(new Node(dest, cost));
    }

    public void dijkstra(int source) {
        PriorityQueue<Node> pq = new PriorityQueue<>(vertices, new Node());
        int[] distance = new int[vertices];

        Arrays.fill(distance, Integer.MAX_VALUE);

        pq.add(new Node(source, 0));

        distance[source] = 0;
        while (!pq.isEmpty()) {
            int u = pq.poll().vertex;

            for (Node neighbor : adj.get(u)) {
                int v = neighbor.vertex;
                int weight = neighbor.cost;

                if (distance[u] + weight < distance[v]) {
                    distance[v] = distance[u] + weight;
                    pq.add(new Node(v, distance[v]));
                }
            }
        }

        // Print the distances
        for (int i = 0; i < distance.length; i++)
            System.out.println(i + " - " + distance[i]);
    }

    public static void main(String[] args) {
        int vertices = 6;
        Graph graph = new Graph(vertices);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 3, 4);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 5, 6);
        graph.dijkstra(0);
    }
}

