class Solution {
    public void moveZeroes(int[] nums) {
        int i = nums.length-1, j = nums.length-1;
        for( ; i >= 0; i--){
            if(nums[i] == 0){
                for(int k = i + 1; k <= j; k++){
                    nums[k-1] = nums[k];
                }
                nums[j] = 0;
                j--;
            }
        }
    }
}