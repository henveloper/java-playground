package grind75medium;

import java.util.Comparator;
import java.util.PriorityQueue;

// link: https://leetcode.com/problems/k-closest-points-to-origin/
/**
 * Explaination: Min heap
 * Complexity: O(n + k lg n) time, O(n) space
 */
class _Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>(
                k,
                new Comparator<int[]>() {
                    @Override
                    public int compare(int[] a, int[] b) {
                        return a[0] * a[0] + a[1] * a[1] - b[0] * b[0] - b[1] * b[1];
                    }
                });

        for (int[] point : points) {
            minHeap.add(point);
        }

        int[][] soln = new int[k][2];
        for (int i = 0; i < k; i++) {
            soln[i] = minHeap.poll();
        }

        return soln;
    }
}