package grind75;

/*
 * Link: https://leetcode.com/problems/symmetric-tree/submissions/
 * Explaination: trivial
 * Complexity: /
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
    public boolean isSymmetric(TreeNode root) {
        // check 2 tree equal
        return treesSymmetric(root.left, root.right);
    }

    public boolean treesSymmetric(TreeNode n, TreeNode m) {
        if (n == null && m == null) {
            return true;
        }
        if (n != null && m != null && n.val == m.val) {
            return treesSymmetric(n.left, m.right) && treesSymmetric(n.right, m.left);
        }
        return false;
    }
}