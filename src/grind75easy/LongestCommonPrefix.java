package grind75easy;

/*
 * Link: https://leetcode.com/problems/longest-common-prefix/
 * Explaination: trivial
 * Optimality: /
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder builder = new StringBuilder();

        for (int charPtr = 0; charPtr < strs[0].length(); charPtr++) {
            char base = strs[0].charAt(charPtr);
            for (String str : strs) {
                if (charPtr >= str.length() || str.charAt(charPtr) != base) {
                    return builder.toString();
                }
            }
            builder.append(base);
        }
        return builder.toString();
    }
}