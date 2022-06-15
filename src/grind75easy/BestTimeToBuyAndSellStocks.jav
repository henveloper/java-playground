package grind75;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int min = prices[0];
        int max = prices[0];

        for (int price : prices) {
            if (price < min) {
                min = price;
                max = price;
            } else if (price > max) {
                max = price;
                int profit = max - min;
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        return maxProfit;
    }
}