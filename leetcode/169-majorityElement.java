class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length == 0 || nums == null) return 0;
        if(nums.length <= 2) return nums[0];
        Arrays.sort(nums);
        int mid = nums.length / 2;
        if(nums[mid] == nums[mid+1] || nums[mid] == nums[mid-1])
            return nums[mid];
        return nums[mid-1];
    }
}
