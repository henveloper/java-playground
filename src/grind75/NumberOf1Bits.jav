package grind75;

import java.math.BigInteger;

/*
 * Link: https://leetcode.com/problems/number-of-1-bits/
 * Explaination: java bullshit
 * Optimality: /
 */
class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int counter = 0;
        while (n != 0) {
            counter += (n & 1);
            n = (n >>> 1);
        }
        return counter;
    }
}