package grind75;

/*
 * Link: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 * Explaination: 
 * Complexity:
 * Alternative Solutions: 
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
    public int[] nums;
    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        int start = 0;
        int end = nums.length - 1;
        int mid = mid(start, end);
        TreeNode root = new TreeNode(nums[mid]);
        resolveChildrens(nums, root);
        return root;
    }

    public void resolveChildrens(int[] nums, TreeNode node) {
        int start = 0;
        int end = nums.length - 1;
        int mid = mid(start, end);
        node.left = getMidNode(start, mid);
    }

    public TreeNode getMidNode(int start, int end) {
        if (end < start) {
            return null;
        } 
        return new TreeNode(nums[mid(start, end)]);

    }

    public int mid(int start, int end) {
        return (start + end) / 2;
    }
}