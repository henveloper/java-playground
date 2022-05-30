package grind75;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/two-sum/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer matchLocation = map.get(target - nums[i]);
            if (matchLocation != null) {
                return new int[] {i, matchLocation};
            }

            map.put(nums[i], i);
        }
        
        return new int[0];
    }
}
