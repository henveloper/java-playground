package grind75;

import java.util.HashMap;
import java.util.Map;

/*
 * Link: https://leetcode.com/problems/contains-duplicate/
 * Explaination: This one is trivial, or we trade time for space.
 */
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int n : nums) {
            if (map.getOrDefault(n, false)) {
                return true;
            }
            map.put(n, true);
        }
        return false;
    }
}