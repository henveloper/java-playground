package grind75;

/*
 * Link: https://leetcode.com/problems/reverse-bits/
 * Explaination: 
 * Optimality:
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
        return solve(0, nums.length - 1);
    }

    public TreeNode solve(int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        return new TreeNode(
            nums[mid],
            solve(start, mid-1),
            solve(mid+1, end)
        );
    }
}