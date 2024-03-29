package edu.problems.leetcode_interview_crash_course_dsa.binary_trees.dfs;

/**
 Given the root of a binary tree, return the length of the diameter of the tree.

 The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 This path may or may not pass through the root.

 The length of a path between two nodes is represented by the number of edges between them.
 */
public class DiameterBinaryTree {
    private int diameter;

    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        longestPath(root);
        return diameter;
    }

    int longestPath(TreeNode node){
        if(node == null) return 0;

        int left = longestPath(node.left);
        int right = longestPath(node.right);
        diameter = Math.max(diameter, left + right);
        return  Math.max(left ,right) + 1;
    }
}
