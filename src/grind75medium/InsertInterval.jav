package grind75medium;

/**
 * link: https://leetcode.com/problems/insert-interval/
 * explaination: 
 * complexity:
 * alternative solution:
 */
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[] startInfo = position(newInterval[0], intervals);
        int[] endInfo = position(newInterval[1], intervals);

        if (startInfo[0] == 1 && endInfo[0] == 1) {
            /**
             * both ends in some intervals
             * solution length = n - (b-a)
             */
            int[][] soln = new int[intervals.length - (endInfo[1] - startInfo[1])][2];
            int srcPtr = 0;
            for (int solnPtr = 0; solnPtr < soln.length; solnPtr++) {
                if (srcPtr == startInfo[1]) {
                    soln[solnPtr][0] = intervals[srcPtr][0];
                    srcPtr = endInfo[1];
                    soln[solnPtr][1] = intervals[srcPtr][1];
                } else {
                    soln[solnPtr][0] = intervals[srcPtr][0];
                    soln[solnPtr][1] = intervals[srcPtr][1];
                }
                srcPtr++;
            }
            return soln;
        } else if (startInfo[0] == 0 && endInfo[0] == 0) {
            /**
             * both ends not in some intervals
             * soln length = n - (b-a) + 1
             */
            int[][] soln = new int[intervals.length - (endInfo[1] - startInfo[1]) + 1][2];
            int srcPtr = 0;
            for (int solnPtr = 0; solnPtr < soln.length; solnPtr++) {
                if (solnPtr == startInfo[1]) {
                    soln[solnPtr][0] = newInterval[0];
                    soln[solnPtr][1] = newInterval[1];
                    srcPtr = endInfo[1];
                } else {
                    soln[solnPtr][0] = intervals[srcPtr][0];
                    soln[solnPtr][1] = intervals[srcPtr][1];
                    srcPtr++;
                }
            }
            return soln;
        } else if (startInfo[0] == 1) {
            /**
             * start in interval, end not in interval
             * soln length = n - ((b-a) - 1)
             */
            int[][] soln = new int[intervals.length - ((endInfo[1] - startInfo[1]) - 1)][2];
            int srcPtr = 0;
            for (int solnPtr = 0; solnPtr < soln.length; solnPtr++) {
                if (startInfo[1] == solnPtr) {
                    soln[solnPtr][0] = intervals[srcPtr][0];
                    soln[solnPtr][1] = newInterval[1];
                    srcPtr = endInfo[1];
                } else {
                    soln[solnPtr][0] = intervals[srcPtr][0];
                    soln[solnPtr][1] = intervals[srcPtr][1];
                    srcPtr++;
                }
            }
            return soln;
        } else {
            /**
             * start not in interval, end in interval
             * soln length = n -(b-a)
             */
            int[][] soln = new int[intervals.length - (endInfo[1] - startInfo[1])][2];
            int srcPtr = 0;
            for (int solnPtr = 0; solnPtr < soln.length; solnPtr++) {
                if (startInfo[1] == solnPtr) {
                    soln[solnPtr][0] = newInterval[0];
                    srcPtr = endInfo[1];
                    soln[solnPtr][1] = intervals[srcPtr][1];
                } else {
                    soln[solnPtr][0] = intervals[srcPtr][0];
                    soln[solnPtr][1] = intervals[srcPtr][1];
                }
                srcPtr++;
            }
            return soln;
        }
    }

    /**
     * representation of a location in the schedule
     * 
     * binary search, pair of interval as one unit
     * interval[0], interval[0+1] to interval[n-2] interval[n-1];
     * 
     * [isInInterval, position]
     * isInInterval = 0 => 0 ... n positions
     * isInInterval = 1 => 0 ... n-1 positions
     */
    public int[] position(int value, int[][] intervals) {
        // edge cases
        if (intervals.length == 0) {
            return new int[] { 0, 0 };
        }

        if (value < intervals[0][0]) {
            return new int[] { 0, 0 };
        }

        if (value > intervals[intervals.length - 1][1]) {
            return new int[] { 0, intervals.length };
        }

        if (intervals.length == 1) {
            // must be in the only interval since outside are returned by above guards
            return new int[] { 1, 0 };
        }

        // binary search
        int start = 0;
        int end = intervals.length - 2;
        while (true) {
            int mid = (start + end) / 2;
            int a = intervals[mid][0];
            int b = intervals[mid][1];
            int c = intervals[mid + 1][0];
            int d = intervals[mid + 1][1];

            if (value < a) {
                end = mid - 1;
                continue;
            }

            if (value > d) {
                start = mid + 1;
                continue;
            }

            // in the interval
            if (a <= value && value <= b) {
                return new int[] { 1, mid };
            }
            if (b < value && value < c) {
                return new int[] { 0, mid + 1 };
            }
            if (c <= value && value <= d) {
                return new int[] { 1, mid + 1 };
            }
        }
    }
}