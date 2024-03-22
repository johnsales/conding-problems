package edu.problems.leetcode_interview_crash_course_dsa.binary_trees.dfs;

/**
 Given the root of a binary tree, find the maximum value v for which there exist different nodes a and b
 where v = |a.val - b.val| and a is an ancestor of b.

 A node a is an ancestor of b if either: any child of a is equal to b or any child of a is an ancestor of b.
 */
public class MaximumDifferenceBetweenNodeAndAncestor {
    public int maxAncestorDiff(TreeNode root) {
        return helper(root, root.val, root.val);
    }

    public int helper(TreeNode node, int curMax, int curMin){
        if(node == null) return curMax - curMin;

        //Otherwise, update max and min and return the max of left and right subtress
        curMax = Math.max(curMax, node.val);
        curMin = Math.min(curMin, node.val);
        int left = helper(node.left, curMax, curMin);
        int right = helper(node.right, curMax, curMin);

        return Math.max(left,right);
    }
}
