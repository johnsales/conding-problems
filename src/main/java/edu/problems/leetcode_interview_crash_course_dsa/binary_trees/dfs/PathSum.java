package edu.problems.leetcode_interview_crash_course_dsa.binary_trees.dfs;

/**
 Given the root of a binary tree and an integer targetSum, return true if the tree has a
 root-to-leaf path such that adding up all the values along the path equals targetSum.

 A leaf is a node with no children.
 */
public class PathSum {
    int target;

    //O(n) & O(n)
    public boolean hasPathSum(TreeNode root, int targetSum) {
        target = targetSum;
        return dfs(root,0);
    }

    public boolean dfs(TreeNode root, int curr){
        if(root == null) return false;
        if(root.left == null && root.right == null)
            return (root.val + curr) == target;
        curr+= root.val;

        boolean left = dfs(root.left,curr);//or return if left is true to avoid unnecessary iteration
        boolean right = dfs(root.right,curr);
        return left || right;
    }
}
