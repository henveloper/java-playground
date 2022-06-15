package grind75;

// https://leetcode.com/problems/valid-palindrome/
class Solution {
    public boolean isPalindrome(String s) {
        String clean = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        if (clean.length() == 0) {
            return true;
        }

        for (int i = 0; i < clean.length() / 2; i++) {
            if (clean.charAt(i) != clean.charAt(clean.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}