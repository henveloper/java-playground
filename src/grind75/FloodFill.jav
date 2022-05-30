package grind75;

import java.util.Stack;

// https://leetcode.com/problems/flood-fill/
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m = image.length;
        int n = image[0].length;
        int rootColor = image[sr][sc];

        boolean[][] processed = new boolean[m][n];

        Stack<int[]> stack = new Stack<>();
        stack.add(new int[] { sr, sc });

        while (!stack.isEmpty()) {
            int[] parent = stack.pop();

            image[parent[0]][parent[1]] = newColor;
            processed[parent[0]][parent[1]] = true;

            int[][] neighbours = new int[][] {
                    { parent[0], parent[1] + 1 },
                    { parent[0], parent[1] - 1 },
                    { parent[0] + 1, parent[1] },
                    { parent[0] - 1, parent[1] },
            };
            for (int[] neighbour : neighbours) {
                if (neighbour[0] < 0 || neighbour[0] >= m) {
                    continue;
                }
                if (neighbour[1] < 0 || neighbour[1] >= n) {
                    continue;
                }
                if (image[neighbour[0]][neighbour[1]] != rootColor) {
                    continue;
                }

                if (processed[neighbour[0]][neighbour[1]]) {
                    continue;
                }
                
                stack.add(neighbour);
            }
        }

        return image;
    }
}