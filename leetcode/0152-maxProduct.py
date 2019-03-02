class Solution:
    def maxProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        res = cur_max = cur_min = nums[0]
        for num in nums[1:]:
            cur_max, cur_min = max(cur_max * num, cur_min * num, num), min(cur_max * num, cur_min * num, num)
            res =  max(res, cur_max)
        return res
