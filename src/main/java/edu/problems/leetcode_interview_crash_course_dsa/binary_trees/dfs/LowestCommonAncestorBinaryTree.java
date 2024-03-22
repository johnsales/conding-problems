package edu.problems.leetcode_interview_crash_course_dsa.binary_trees.dfs;

/**
 Given the root of a binary tree and two nodes p and q that are in the tree, return the lowest common ancestor (LCA)
 of the two nodes. The LCA is the lowest node in the tree that has both p and q as descendants
 (note: a node is a descendant of itself).
 */
public class LowestCommonAncestorBinaryTree {

    //O(n) & O(n)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        // first case
        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // second case
        if (left != null && right != null) {
            return root;
        }

        // third case
        if (left != null) {
            return left;
        }

        return right;
    }
}
