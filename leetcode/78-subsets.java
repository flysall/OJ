class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<Integer>(), nums, 0);
        return list;
    }
    public void backtrack(List<List<Integer>> list, List<Integer> item, int[] nums, int start){
        list.add(new ArrayList<Integer>(item));
        for(int i = start; i < nums.length; i++){
            item.add(nums[i]);
            backtrack(list, item, nums, i+1);
            item.remove(item.size()-1);
        }
    }
}
