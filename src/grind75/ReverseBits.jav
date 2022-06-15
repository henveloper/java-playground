package grind75;

/*
 * Link: 
 * Explaination: 
 * Optimality:
 */
class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int complementBit = n >= 0 ? 0 : 1;
        n <<= 1;
        n >>>= 1;

        // construct the reverse of last 31th digit then shift it up
        int sum = 0;
        int offset = 0; // 1 << (30-offset) = 2 ^ offset
        while (n != 0) {
            int lsb = (n & 1);
            n /= 2;
            if (lsb == 1) {
                sum += 1 << (30 - offset);
            }
            offset += 1;
        }
        sum <<= 1;

        return sum += complementBit;
    }
}