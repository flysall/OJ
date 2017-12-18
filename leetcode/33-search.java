class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        int low = 0, high = len-1;
        while(low < high){
            int mid = (low + high) / 2;
            if(nums[mid] > nums[high]) low = mid+1;
            else high = mid;
        }
        int rot = low;
        low = 0; high = len-1;
        while(low <= high){
            int mid = (low + high) / 2;
            int realmid = (mid + rot) % len;
            if(nums[realmid] == target) return realmid;
            if(nums[realmid] < target) low = mid+1;
            else high = mid-1;
        }
        return -1;
    }
}
