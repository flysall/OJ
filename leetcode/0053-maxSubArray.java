class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int res = nums[0], curMax = nums[0], len = nums.length;
        for (int i = 1; i < len; ++i) {
            curMax = curMax > 0 ? curMax + nums[i] : nums[i];
            res = Math.max(curMax, res);
        }
        return res;
    }
}
