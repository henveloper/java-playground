package grind75;

/*
 * Link: https://leetcode.com/problems/move-zeroes/
 * Explaination: trivial  
 * Complexity: yes
 */
class Solution {
    public void moveZeroes(int[] nums) {
        int nonZeroPtr = 0;
        for (int n : nums) {
            if (n != 0) {
                nums[nonZeroPtr++] = n;
            }
        }
        for (int zeroFillPtr = nonZeroPtr; zeroFillPtr < nums.length; zeroFillPtr++) {
            nums[zeroFillPtr] = 0;
        }
    }
}