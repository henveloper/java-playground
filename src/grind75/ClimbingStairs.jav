package grind75;

// https://leetcode.com/problems/climbing-stairs/
class Solution {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        int climb1 = 2;
        int climb2 = 1;
        int i = 2;

        while (true) {
            i++;
            if (i == n) {
                return climb1 + climb2;
            }

            int tmp = climb1+climb2;
            climb2 = climb1;
            climb1 = tmp;
        }
    }
}