class Solution {
    public void moveZeroes(int[] nums) {
        int point = 0, len = nums.length;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0)
                nums[point++] = nums[i];
        }
        for( ; point < len; point++)
            nums[point] = 0;
    }
}
