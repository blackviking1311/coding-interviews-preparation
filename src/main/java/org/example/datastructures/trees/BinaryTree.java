package org.example.datastructures.trees;

import java.util.*;

public class BinaryTree {
    private TreeNode root;

    public BinaryTree() {
        this.root = null;
    }

    public TreeNode getNewNode(int data) {
        return new TreeNode(data);
    }

    public void insertNode(int data) {
        TreeNode newNode = getNewNode(data);
        if (root == null) {
            this.root = newNode;
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();

            if (node.left == null) {
                node.left = newNode;
                return;
            } else if (node.right == null) {
                node.right = newNode;
                return;
            }

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    //  in order traversal using a stack
    public List<Integer> inorder(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        while (true) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                if (stack.isEmpty()) {
                    break;
                }

                node = stack.pop();
                ans.add(node.data);
                node = node.right;
            }
        }

        return ans;
    }

    public void levelOrderTraversal() {
        TreeNode root = this.root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            System.out.print(node.data + " : ");

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    public List<Integer> preorder(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ans.add(node.data);

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return ans;
    }

    public List<Integer> postorder(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ans.add(node.data);

            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }

        for (int el : ans) {
            System.out.print(el + " : ");
        }

        Collections.reverse(ans);
        return ans;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0 ; i < size ; i++) {
                TreeNode node = queue.remove();
                level.add(node.data);

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            ans.add(level);
        }

        return ans;
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        for (int i = 0 ; i < 5 ; i++) {
            binaryTree.insertNode(i + 1);
        }

        binaryTree.postorder(binaryTree.root);
    }
}
