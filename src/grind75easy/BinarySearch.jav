package grind75;

// https://leetcode.com/problems/binary-search/
class Solution {
    public int search(int[] nums, int target) {
        int min = 0;
        int max = nums.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        return -1;
    }
}