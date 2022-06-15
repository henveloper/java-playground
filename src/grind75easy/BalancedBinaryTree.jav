package grind75;

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
    public boolean isBalanced(TreeNode root) {
        int height = height(root);
        return height != -10;
    }

    public int height(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        if ((leftHeight == rightHeight + 1 || leftHeight + 1 == rightHeight || leftHeight == rightHeight) && leftHeight != -10) {
            return Math.max(leftHeight, rightHeight) + 1;
        }

        return -10;
    }
}