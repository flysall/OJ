class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 2) return nums.length;
        int p = 1, pre = 0;
        while(p < nums.length){
            if(nums[p] == nums[pre]){
                p++;
                while(p < nums.length && nums[p] == nums[p-1]) 
                    p++;
                nums[++pre] = nums[p-1];
            } else{
                nums[++pre] = nums[p++];
            }
        }
        return pre+1;
    }
}
