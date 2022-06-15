package grind75;

/*
 * Link: https://leetcode.com/problems/squares-of-a-sorted-array/
 * Explaination: trivial
 * Optimality:
 */
class Solution {
    public int[] sortedSquares(int[] nums) {
        // edge cases
        // case 1, all non neg increasing
        if (nums[0] >= 0) {
            int[] soln = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                soln[i] = nums[i] * nums[i];
            }
            return soln;
        }

        // case 2, all non positive increasing
        if (nums[nums.length - 1] <= 0) {
            int[] soln = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                soln[i] = nums[nums.length - 1 - i] * nums[nums.length - 1 - i];
            }
            return soln;
        }

        // case 3, 2 element no zero
        if (nums.length == 2) {
            int[] soln = new int[2];
            if (Math.abs(nums[0]) <= Math.abs(nums[1])) {
                soln[0] = nums[0] * nums[0];
                soln[1] = nums[1] * nums[1];
            } else {
                soln[1] = nums[0] * nums[0];
                soln[0] = nums[1] * nums[1];
            }

            return soln;
        }

        // finding the "v-point"
        int mid = -1; // must exist by problem stmt
        for (int i = 0; i < nums.length - 2; i++) {
            int l = Math.abs(nums[i]);
            int m = Math.abs(nums[i + 1]);
            int h = Math.abs(nums[i + 2]);
            if (l >= m && h >= m) {
                mid = i + 1;
                break;
            }
        }

        // construct the solution array
        int[] soln = new int[nums.length];
        soln[0] = nums[mid] * nums[mid];
        int lIt = mid - 1;
        int rIt = mid + 1;
        for (int fillingPtr = 1; fillingPtr < nums.length; fillingPtr++) {
            if (lIt < 0) {
                soln[fillingPtr] = nums[rIt] * nums[rIt];
                rIt++;
                continue;
            }
            if (rIt >= nums.length) {
                soln[fillingPtr] = nums[lIt] * nums[lIt];
                lIt--;
                continue;
            }

            if (Math.abs(nums[lIt]) < Math.abs(nums[rIt])) {
                soln[fillingPtr] = nums[lIt] * nums[lIt];
                lIt--;
            } else {
                soln[fillingPtr] = nums[rIt] * nums[rIt];
                rIt++;
            }
        }
        return soln;
    }
}