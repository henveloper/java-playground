package leetcode;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

// link: https://leetcode.com/problems/3sum/
/**
 * Explaination: /
 * Complexity O(n^2) time, O(n) space
*/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, Integer> positionMap = new LinkedHashMap<>();
        List<List<Integer>> soln = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            positionMap.put(nums[i], Math.min(i, positionMap.getOrDefault(nums[i], Integer.MAX_VALUE)));
        }

        for (int i = 0; i < positionMap.size(); i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int lastValue = -nums[i] - nums[j];
                if (positionMap.getOrDefault(lastValue, -1) > j) {
                    List<Integer> triple = new ArrayList<>();
                    triple.add(nums[i]);
                    triple.add(nums[j]);
                    triple.add(-nums[i] - nums[j]);
                    soln.add(triple);
                }
            }
        }
        return soln;
    }
}