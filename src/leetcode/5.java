package leetcode;

// link: 
/**
 * Explaination:
 * Complexity:
 */
class Solution {
    public String longestPalindrome(String s) {
        int maxPalindromeLen = 1;
        int maxLeft = 0;
        int maxRight = 0;
        int n = s.length();

        // odd
        for (int i = 0; i < n; i++) {
            int left = i - 1;
            int right = i + 1;
            while (left >= 0 && right < n) {
                if (s.charAt(left) == s.charAt(right)) {
                    if (right - left + 1 > maxPalindromeLen) {
                        maxPalindromeLen = right - left + 1;
                        maxLeft = left;
                        maxRight = right;
                    }
                } else {
                    break;
                }
                left--;
                right++;
            }
        }

        if (n > 1) {
            for (int i = 0; i < n - 1; i++) {
                int left = i;
                int right = i + 1;
                while (left >= 0 && right < n) {
                    if (s.charAt(left) == s.charAt(right)) {
                        if (right - left + 1 > maxPalindromeLen) {
                            maxPalindromeLen = right - left + 1;
                            maxLeft = left;
                            maxRight = right;
                        }
                    } else {
                        break;
                    }
                    left--;
                    right++;
                }
            }

        }

        return s.substring(maxLeft, maxRight + 1);
    }
}
