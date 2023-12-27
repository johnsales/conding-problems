package edu.problems.algorithms;

import java.util.*;

public class DFS {

    public static void main(String[] args) {
        // Constructing the tree:
        //        4
        //      /   \
        //     2     6
        //    / \   / \
        //   1   3 5   7

        DFS.TreeNode root = new DFS.TreeNode(4);
        root.left = new DFS.TreeNode(2);
        root.right = new DFS.TreeNode(6);
        root.left.left = new DFS.TreeNode(1);
        root.left.right = new DFS.TreeNode(3);
        root.right.left = new DFS.TreeNode(5);
        root.right.right = new DFS.TreeNode(7);

        dfsBinaryTree(root);
    }

    /**
     Time Complexity: O(n) where n is the number of nodes in the tree.
     Space Complexity: In the worst case, it's the height of the tree. For a balanced binary tree, it's
     O(log n), but for a skewed tree, it can be O(n)
     * @param node
     */
    public static void dfsBinaryTree(TreeNode node) {
        if (node == null) return;

        // Process the node (pre-order)
        System.out.print(node.val + " ");

        dfsBinaryTree(node.left);   // Traverse left subtree
        dfsBinaryTree(node.right);  // Traverse right subtree
    }

    /**
     Time Complexity: O(V+E) where V is the number of vertices and E is the number of edges.
     This accounts for visiting all nodes and traversing all edges.
     Space Complexity: O(V). This is because, in the worst case, you'll be storing all vertices
     in the stack or recursive call stack.

     * @param node
     * @param adjMap
     * @param visited
     */
    public void dfsGraph(int node, Map<Integer, List<Integer>> adjMap, Set<Integer> visited) {
        if (visited.contains(node)) return;

        visited.add(node);
        System.out.print(node + " "); // Process the node

        for (int neighbor : adjMap.getOrDefault(node, new ArrayList<>())) {
            dfsGraph(neighbor, adjMap, visited);
        }
    }

    /**
     1 - Initialize a queue.
     2 - Add the root to the queue.
     3 - While the queue is not empty:
         ...
     * @param start
     * @param adjMap
     */
    public void dfsGraphUsingStack(int start, Map<Integer, List<Integer>> adjMap) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();

        stack.push(start);

        while (!stack.isEmpty()) {
            int current = stack.pop();

            // Ensure we process each node only once
            if (!visited.contains(current)) {
                visited.add(current);
                System.out.print(current + " "); // Process the current node

                // Add neighbors to the stack
                for (int neighbor : adjMap.getOrDefault(current, new ArrayList<>())) {
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);
                    }
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
