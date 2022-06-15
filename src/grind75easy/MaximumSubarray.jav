package grind75;

// https://leetcode.com/problems/maximum-subarray/
class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int prevMax = 0;
        for (int num : nums) {
            int localMax = prevMax < 0 ? num : prevMax + num;
            max = Math.max(localMax, max);
            prevMax = localMax;
        }
        return max;
    }
}