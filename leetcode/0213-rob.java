class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int robFirst = nums[0], preRobFirst = 0;
        int notRobFirst = 0, preNotRobFirst = 0;
        int curRobFirst = nums[0], curNotRobFirst = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (i != nums.length-1) {
                curRobFirst = Math.max(preRobFirst+nums[i], robFirst);
                curNotRobFirst = Math.max(preNotRobFirst+nums[i], notRobFirst);
                int tmp = robFirst;
                robFirst = curRobFirst;
                preRobFirst = tmp;
                tmp = notRobFirst;
                notRobFirst = curNotRobFirst;
                preNotRobFirst = tmp;
            } else {
                curNotRobFirst = Math.max(preNotRobFirst+nums[i], notRobFirst);
            }
        }
        return Math.max(curNotRobFirst, curRobFirst);        
    }
}
