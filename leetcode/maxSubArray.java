class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0], maxSum = nums[0];
        for(int i = 1; i < nums.length; i++){
            maxSum = Math.max(maxSum + nums[i], nums[i]);
            max = Math.max(maxSum, max);
        }
        return max;
    }
}