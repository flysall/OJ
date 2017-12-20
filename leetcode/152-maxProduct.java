class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0], curMax = max, curMin = max;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < 0){
                int tmp = curMax;
                curMax = curMin;
                curMin = tmp;
            }
            curMax = Math.max(nums[i], curMax * nums[i]);
            curMin = Math.min(nums[i], curMin * nums[i]);
            max = Math.max(max, curMax);
        }
        return max;
    }
}
