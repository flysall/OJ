class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low = 0, high = nums.length-1, mid = -1;
        while(low <= high){
            mid = low + (high - low) / 2;
            if(nums[mid] < target) low = mid + 1;
            if(nums[mid] > target) high = mid - 1;
            if(nums[mid] == target) break;
        }
        if(mid == -1 || nums[mid] != target) return new int[]{-1, -1};
        low = mid;
        high = mid;
        while(low >= 0 && nums[low] == target) low--;
        while(high < nums.length && nums[high] == target) high++;
        return new int[]{low+1, high-1};
    }
}
