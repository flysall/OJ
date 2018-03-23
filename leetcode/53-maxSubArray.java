class Solution {
    public int maxSubArray(int[] nums) {
        int sum = Integer.MIN_VALUE, tmpSum = 0;
        for(int i = 0; i < nums.length; i++){
            tmpSum = tmpSum + nums[i];
            sum = Math.max(tmpSum, sum);
            if(tmpSum < 0)
                tmpSum = 0;
        }
        return sum;
    }
}
