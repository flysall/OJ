class Solution:
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if nums is None or len(nums) == 0:
            return 0
        elif len(nums) == 1:
            return nums[0]
        return max(self._rob(nums, 0, len(nums)-2), self._rob(nums, 1, len(nums)-1))
    
    def _rob(self, nums, low, high):
        cur, pre_one, pre_two = nums[low], nums[low], 0
        for num in nums[low+1:high+1]:
            cur = max(pre_one, pre_two+num)
            pre_one, pre_two = cur, pre_one
        return cur
