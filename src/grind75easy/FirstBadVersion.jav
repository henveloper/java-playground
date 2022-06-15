package grind75;

// https://leetcode.com/problems/first-bad-version/
class VersionControl {
    public boolean isBadVersion(int v) {
        return true;
    }
}

class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int min = 1;
        int max = n;

        while (min < max) {
            int mid = min + (max - min) / 2;
            if (super.isBadVersion(mid)) {
                max = mid;
            } else {
                min = mid+1;
            }
        }

        return max;
    }
}