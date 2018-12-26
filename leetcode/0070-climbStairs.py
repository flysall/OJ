class Solution:
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        pre = sum = 1
        for _ in range(1, n):
            pre, sum = sum, pre + sum
        return sum
        
