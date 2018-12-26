class Solution {
    public int maxProfit(int[] prices) {
        int res = 0, curMax = 0;
        for (int i = 1; i < prices.length; ++i) {
            curMax += prices[i] - prices[i-1];
            res = Math.max(curMax, res);
            curMax = curMax <= 0 ? 0 : curMax;
        }
        return res;
    }
}
