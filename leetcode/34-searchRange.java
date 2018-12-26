class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = getIndex(nums, target, true);
        res[1] = getIndex(nums, target, false);
        return res;
    }

    private int getIndex(int[] nums, int target, boolean isLeft) {
        int left = 0, right = nums.length-1;
        while(left <= right) {
            int mid = left + ((right - left) >> 1);
            if(target < nums[mid]) {
                right = mid - 1;
            } else if(target > nums[mid]) {
                left = mid + 1;
            } else {
                if(isLeft) {
                    if(mid > 0 && target == nums[mid - 1]) {
                        right = mid - 1;
                    } else {
                        return mid;
                    }
                } else {
                    if(mid < nums.length-1 && target == nums[mid + 1]) {
                        left = mid + 1;
                    } else {
                        return mid;
                    }
                }
            }
        }
        return -1;
    }
}
