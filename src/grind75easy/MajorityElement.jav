package grind75;

// https://leetcode.com/problems/majority-element/
class Solution {
    public int majorityElement(int[] nums) {
        // Moore's Voting Algorithm
        int majority = nums[0];
        int count = 0;
        for (int n : nums) {
            count += (n == majority) ? 1 : -1;
            if (count == 0) {
                majority = n;
                count = 1;
            }
        }

        return majority;
    }
}