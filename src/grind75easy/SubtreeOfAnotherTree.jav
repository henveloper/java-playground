package grind75;

import java.util.Stack;

/*
 * Link: https://leetcode.com/problems/subtree-of-another-tree/
 * Explaination: trivial
 * Optimality: /
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // dfs locate candidates
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode parent = stack.pop();
            if (parent.val == subRoot.val && treeEqual(parent, subRoot)) {
                return true;
            }

            if (parent.left != null) {
                stack.add(parent.left);
            }
            if (parent.right != null) {
                stack.add(parent.right);
            }
        }

        return false;
    }

    private boolean treeEqual(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 != null && t2 != null && t1.val == t2.val) {
            return treeEqual(t1.left, t2.left) && treeEqual(t1.right, t2.right);
        }

        return false;
    }
}