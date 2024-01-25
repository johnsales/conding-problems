package edu.problems.algorithms;

import edu.problems.cracking_code_interview.chapter4.OrderTraversal;

import java.util.*;

public class BFS {

    public static void main(String[] args) {
        // Constructing the tree:
        //        4
        //      /   \
        //     2     6
        //    / \   / \
        //   1   3 5   7

        BFS.TreeNode root = new BFS.TreeNode(4);
        root.left = new BFS.TreeNode(2);
        root.right = new BFS.TreeNode(6);
        root.left.left = new BFS.TreeNode(1);
        root.left.right = new BFS.TreeNode(3);
        root.right.left = new BFS.TreeNode(5);
        root.right.right = new BFS.TreeNode(7);

        bfsBinaryTree(root);

        System.out.println("\n-------------------------");

        List<List<Integer>> adjList = new ArrayList<>();

        // Add the adjacency lists for each node
        adjList.add(Arrays.asList(1, 2));  // Node 0
        adjList.add(Arrays.asList(0, 3));  // Node 1
        adjList.add(Arrays.asList(0, 3));  // Node 2
        adjList.add(Arrays.asList(1, 2));  // Node 3

        bfsGraph(0, adjList);  // Starting BFS traversal from node 0
    }
    /**
     1 - Initialize a queue.
     2 - Add the root to the queue.
     3 - While the queue is not empty:
             Remove the node from the front of the queue.
             Process the node (e.g., print its value).
             If the node has a left child, add it to the end of the queue.
             If the node has a right child, add it to the end of the queue.

     Time Complexity: O(n) where n is the number of nodes in the tree.
     Space Complexity: In the worst case, it's the maximum number of nodes at a level, which for a
     binary tree is O(n/2) = O(n) at the last level in a balanced tree.

     * @param root
     */
    public static void bfsBinaryTree(TreeNode root){
        Queue<TreeNode> q  = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()){
            TreeNode node = q.poll();
            System.out.print(node.val);

            if(node.left != null){
                q.add(node.left);
            }
            if(node.right != null){
                q.add(node.right);
            }
        }
    }

    /**
     1- Choose a starting node.
     2 - Initialize a queue and a set (or a boolean array) for tracking visited nodes.
     3 - Add the starting node to the queue and mark it as visited.
     4 - While the queue is not empty:
         Remove a node from the front of the queue.
         Process the node (e.g., print its value).
         For each of its neighbors:
         If the neighbor has not been visited, add it to the queue and mark it as visited.

     Time Complexity: O(V+E) where V is the number of vertices and E is the number of edges.
     Space Complexity: O(V). In the worst case, every vertex will be stored in the queue or visited set.
     The edges don't contribute to space complexity in BFS since, at any point, only the neighbors
     of one node are inspected.

     * @param start
     * @param adjList
     */
    public static void bfsGraph(int start, List<List<Integer>> adjList) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " "); // Process the current node

            for (int neighbor : adjList.get(current)) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

}





