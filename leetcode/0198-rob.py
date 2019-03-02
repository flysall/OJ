class Solution:
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if (nums is None or len(nums) == 0):
            return 0
        pre_one, pre_two, cur = nums[0], 0, nums[0]
        for num in nums[1:]:
            cur = max(pre_one, pre_two + num)
            pre_one, pre_two = cur, pre_one
        return cur
