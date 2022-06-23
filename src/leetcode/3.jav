package grind75medium;

import java.util.HashMap;
import java.util.Map;

// link: https://leetcode.com/problems/longest-substring-without-repeating-characters/
/**
 * Explaination: 2 pointers 1 pass
 * Complexity: O(n) time, O(1) space
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> charPosMap = new HashMap<>();
        int max = 0;
        int slowPtr = 0;
        int fastPtr = 0;
        for (; fastPtr < s.length(); fastPtr++) {
            int charPos = charPosMap.getOrDefault(s.charAt(fastPtr), 0);
            charPosMap.put(s.charAt(fastPtr), fastPtr + 1);
            if (charPos != 0) {
                slowPtr = Math.max(slowPtr, charPos);
            }
            max = Math.max(max, fastPtr - slowPtr + 1);
        }

        return max;
    }
}
