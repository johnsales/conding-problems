package edu.problems.cracking_code_interview.chapter4;

public class OrderTraversal {
    public static void main(String[] args) {
        // Constructing the tree:
        //        4
        //      /   \
        //     2     6
        //    / \   / \
        //   1   3 5   7

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        System.out.print("In Order Traversal: ");
        inOrderTraversal(root);

        System.out.print("\nPre Order Traversal: ");
        preOrderTraversal(root);

        System.out.print("\nPost Order Traversal: ");
        postOrderTraversal(root);
    }

    public static void inOrderTraversal(TreeNode node) {
        if(node != null){
            inOrderTraversal(node.left);
            System.out.print(node.val);
            inOrderTraversal(node.right);
        }
    }

    public static void preOrderTraversal(TreeNode node) {
        if(node != null){
            System.out.print(node.val);
            inOrderTraversal(node.left);
            inOrderTraversal(node.right);
        }
    }

    public static void postOrderTraversal(TreeNode node) {
        if(node != null){
            inOrderTraversal(node.left);
            inOrderTraversal(node.right);
            System.out.print(node.val);
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
