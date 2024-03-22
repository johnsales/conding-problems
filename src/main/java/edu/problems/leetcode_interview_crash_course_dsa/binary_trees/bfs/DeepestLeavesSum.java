package edu.problems.leetcode_interview_crash_course_dsa.binary_trees.bfs;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 Given the root of a binary tree, return the sum of values of its deepest leaves.
 */
public class DeepestLeavesSum {

    //Leetcode approach
    public int deepestLeavesSum2(TreeNode root) {
        ArrayDeque<TreeNode> nextLevel = new ArrayDeque(),
                currLevel = new ArrayDeque();
        nextLevel.offer(root);

        while (!nextLevel.isEmpty()) {
            // prepare for the next level
            currLevel = nextLevel.clone();
            nextLevel.clear();

            for (TreeNode node: currLevel) {
                // add child nodes of the current level
                // in the queue for the next level
                if (node.left != null) {
                    nextLevel.offer(node.left);
                }
                if (node.right != null) {
                    nextLevel.offer(node.right);
                }
            }
        }
        int deepestSum = 0;
        for (TreeNode node: currLevel) {
            deepestSum += node.val;
        }
        return deepestSum;
    }

    //My Approach
    private int depth;

    public int deepestLeavesSum(TreeNode root) {
        if(root == null) return 0;

        depth = 0;
        int treeDepth = getDepth(root);
        int ans = 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            depth++;
            int elements = q.size();

            for(int i = 0; i < elements; i++){
                TreeNode node = q.remove();

                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);

                if(depth == treeDepth){
                    ans+= node.val;
                }
            }
        }
        return ans;
    }

    public int getDepth(TreeNode root){
        if(root == null) return 0;
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        return Math.max(left,right) + 1;

    }
}
