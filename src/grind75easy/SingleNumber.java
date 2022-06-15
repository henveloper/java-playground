package grind75;

/*
 * Link: https://leetcode.com/problems/single-number/
 * Explaination: XOR operations
 * Optimality: / 
 */
class Solution {
    public int singleNumber(int[] nums) {
        int n = 0;
        for (int m : nums) {
            n = n ^ m;
        }
        return n;
    }
}