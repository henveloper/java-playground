package leetcode;

// link: https://leetcode.com/problems/trapping-rain-water/
/**
 * Brute force
 * Sum each column, height of water by left right maximum => O(n^2) time, O(1) space
 * DP
 * Observed repeated calculation, memoize left right max for each column => O(n) time, O(n) space
 */
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
        }

        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
        }

        int sum = 0;
        for (int i = 1; i < n - 1; i++) {
            if (height[i] >= leftMax[i] || height[i] >= rightMax[i]) {
                continue;
            }

            sum += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return sum;
    }
}