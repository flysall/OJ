class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int len = nums.length, max = Integer.MIN_VALUE;
        int[] dp = new int[len+1];
        for (int i = 1; i <= len; i++) {
            int curMax = Integer.MIN_VALUE;
            for (int j = i-1; j >= 1; j--) {
                if (nums[j-1] < nums[i-1]) {
                    curMax = Math.max(curMax, dp[j]);
                }
            }
            dp[i] = curMax == Integer.MIN_VALUE ? 1 : curMax + 1;
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
