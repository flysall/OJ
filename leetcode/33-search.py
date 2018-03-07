class Solution:
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        l, h = 0, len(nums) - 1
        while l <= h:
            m = l + ((h - l) >> 1)
            if target == nums[m]:
                return m
            elif (nums[m] > nums[l] and target < nums[m] and target >= nums[l]) or (nums[m] < nums[l] and not (target <= nums[h] and target > nums[m])):
                h = m - 1
            else:
                l = m + 1
        return -1
            
        
