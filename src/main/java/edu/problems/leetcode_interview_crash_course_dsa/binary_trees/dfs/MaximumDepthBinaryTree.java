package edu.problems.leetcode_interview_crash_course_dsa.binary_trees.dfs;

import java.util.Stack;

public class MaximumDepthBinaryTree {

    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.left);
        return Math.max(left,right) + 1;
    }

    public int maxDepthInteractive(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 1));
        int ans = 0;

        while (!stack.empty()) {
            Pair pair = stack.pop();
            TreeNode node = pair.node;
            int depth = pair.depth;

            ans = Math.max(ans, depth);
            if (node.left != null) {
                stack.push(new Pair(node.left, depth + 1));
            }
            if (node.right != null) {
                stack.push(new Pair(node.right, depth + 1));
            }
        }
        return ans;
    }

    class Pair {
        TreeNode node;
        int depth;
        Pair(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
}