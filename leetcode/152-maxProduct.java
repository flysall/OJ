class Solution {
    public int maxProduct(int[] nums) {
<<<<<<< HEAD
        if(nums == null || nums.length == 0){
            return 0;
        }
        int max = nums[0], min = nums[0], result = nums[0];
        for(int i = 1; i < nums.length; i++){
            int temp = max;
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);
            if(max > result){
                result = max;
            }
        }
        return result;
    }
}
=======
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
>>>>>>> e95c18b2fe32861f8d55d8bab555884643ecc9b5
