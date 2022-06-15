package grind75;

/*
 * Link: https://leetcode.com/problems/counting-bits/
 * Explaination: trivial
 * Optimality: yes
 */
class Solution {
    public int[] countBits(int n) {
        int[] arr = new int[n + 1];

        // currMultiple + multiplePtr is our ptr
        int twoRaised = 1;
        int offset = 0;
        while (twoRaised + offset <= n && true) {
            while (twoRaised + offset <= n && offset < twoRaised) {
                arr[twoRaised + offset] = arr[offset] + 1;
                offset += 1;
            }
            twoRaised *= 2;
            offset = 0;
        }

        return arr;
    }
}