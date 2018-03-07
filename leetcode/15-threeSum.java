class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < nums.length-2; i++){
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            int sum = -nums[i];
            int j = i+1, k = nums.length-1;
            while(j < k){
                if(nums[k] + nums[j] < sum){
                    j++;
                } else if(nums[k] + nums[j] > sum){
                    k--;
                } 
                else{
                    list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--; 
                    while(j < k && nums[j] == nums[j-1]) j++;
                    while(j < k && nums[k] == nums[j-1]) k--;
                }
            }
        }
        return list;
    }
}
