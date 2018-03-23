class Solution {
    // 题目要求移动到下一行的相邻数字
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] nums = new int[triangle.size()+1];
        for(int i = triangle.size()-1; i >= 0; i--){
            for(int j = 0; j < triangle.get(i).size(); j++)
                nums[j] = Math.min(nums[j], nums[j+1]) + triangle.get(i).get(j);
        }
        return nums[0];
    }
}
