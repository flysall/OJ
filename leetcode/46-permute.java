class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        backtrack(res, new ArrayList<Integer>(), nums);
        return res;
    }
    private void backtrack(List<List<Integer>> list, List<Integer> item, int[] nums) {
        if(item.size() == nums.length)
            list.add(new ArrayList<>(item));
        else {
            for(int i = 0; i < nums.length; i++) {
                if(item.contains(nums[i])) continue;
                item.add(nums[i]);
                backtrack(list, item, nums);
                item.remove(item.size()-1);
            }
        }
    }
}
