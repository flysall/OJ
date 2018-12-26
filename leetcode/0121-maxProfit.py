class Solution:
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        res, cur_max = 0, 0
        for i in range(1, len(prices)):
            cur_max += prices[i] - prices[i-1]
            res = max(cur_max, res)
            cur_max = 0 if cur_max <= 0 else cur_max
        return res
