class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0], curMax = nums[0], curMin = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            int tmpCurMax = curMax;
            curMax = Math.max(Math.max(curMax * nums[i], curMin * nums[i]), nums[i]);
            curMin = Math.min(Math.min(curMin * nums[i], tmpCurMax * nums[i]), nums[i]);
            res = Math.max(curMax, res);
        }
        return res;
    }
}
