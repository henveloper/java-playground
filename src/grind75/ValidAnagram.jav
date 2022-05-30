package grind75;

// https://leetcode.com/problems/valid-anagram/
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] counts = new int[26];

        if (s.length() != t.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            counts[(int) s.charAt(i) - 97] += 1;
            counts[(int) t.charAt(i) - 97] -= 1;
        }

        for (int c: counts) {
            if (c != 0) {
                return false;
            }
        }

        return true;
    }
}