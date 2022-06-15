package grind75;

/*
 * Link: https://leetcode.com/problems/missing-number/
 * Explaination: trivial
 * Complexity: /
 * Alternative Solutions: XOR canceling
 */
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int total = n * (n + 1) / 2;
        for (int m : nums) {
            total -= m;
        }
        return total;
    }
}