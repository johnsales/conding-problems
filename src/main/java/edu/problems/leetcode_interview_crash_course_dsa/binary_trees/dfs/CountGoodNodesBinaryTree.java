package edu.problems.leetcode_interview_crash_course_dsa.binary_trees.dfs;

/**
 Given the root of a binary tree, find the number of nodes that are good. A node is good if the path between the root
 and the node has no nodes with a greater value.
 */
public class CountGoodNodesBinaryTree {

    //O(n) & O(n)
    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    public int dfs(TreeNode node, int maxSoFar) {
        if (node == null) {
            return 0;
        }

        int left = dfs(node.left, Math.max(maxSoFar, node.val));
        int right = dfs(node.right, Math.max(maxSoFar, node.val));
        int ans = left + right;
        if (node.val >= maxSoFar) {
            ans += 1;
        }

        return ans;
    }
}
