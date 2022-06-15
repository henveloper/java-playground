package grind75;

// https://leetcode.com/problems/longest-palindrome/
class Solution {
    public int longestPalindrome(String s) {
        int[] counts = new int[58];
        for (char c : s.toCharArray()) {
            counts[c - 'A']++;
        }

        int numEven = 0;
        boolean hasOdd = false;

        for (int count : counts) {
            if (count % 2 == 1) {
                hasOdd = true;
                numEven += count - 1;
            } else {
                numEven += count;
            }

        }

        return numEven + (hasOdd ? 1 : 0);
    }
}