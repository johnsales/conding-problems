package edu.problems.leetcode_interview_crash_course_dsa.binary_trees.dfs;

/**
 Given the roots of two binary trees p and q, check if they are the same tree. Two binary trees are the same tree
 if they are structurally identical and the nodes have the same values.
 */
public class SameTree {

    //O(n) & O(n)
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right, q.right);
        return left && right;
    }
}
