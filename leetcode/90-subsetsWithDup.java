class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<Integer>(), nums, 0);
        return list;
    }
    private void backtrack(List<List<Integer>> list, List<Integer> item, int[] nums, int start){
        list.add(new ArrayList(item));
        for(int i = start; i < nums.length; i++){
            while(i > start && i < nums.length && nums[i] == nums[i-1])
                i++;
            if(i == nums.length) return;
            item.add(nums[i]);
            backtrack(list, item, nums, i+1);
            item.remove(item.size()-1);
        }
    }
}
