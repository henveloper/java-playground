package grind75;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/ransom-note/
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : magazine.toCharArray()) {
            Integer value = map.get(c);
            if (value == null) {
                value = 0;
            }

            map.put(c, 1 + (value == null ? 0 : value));
        }

        for (char c : ransomNote.toCharArray()) {
            Integer value = map.get(c);
            if (value == null || value == 0) {
                return false;
            }

            map.put(c, value - 1);
        }

        return true;
    }
}