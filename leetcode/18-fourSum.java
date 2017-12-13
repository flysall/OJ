class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums.length < 4)
            return result;
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1, sum4 = 0;
        while(left < right - 2){
            int midLeft = left + 1, midRight = right - 1;
            int sum2 = nums[left] + nums[right];
            
            while(midLeft < midRight){
            	int sum3 = nums[midLeft] + nums[midRight];
                if(sum2 + sum3 < target){
                	while(midLeft < nums.length - 1 && nums[midLeft] == nums[midLeft + 1])
                		midLeft++;
                	midLeft++;
                }
                else if(sum2 + sum3 > target){
                	while(midRight > 0 && nums[midRight] == nums[midRight] - 1)
                		midRight--;
                	midRight--;
                }
                else{
                    List<Integer> tempList = new  ArrayList<Integer>();
                    tempList.add(nums[left]);
                    tempList.add(nums[midLeft]);
                    tempList.add(nums[midRight]);
                    tempList.add(nums[right]);
                    result.add(tempList);
                    while(midRight > 0 && nums[midRight] == nums[midRight - 1])
                    	midRight--;
                    while(midLeft < nums.length - 1 && nums[midLeft] == nums[midLeft + 1])
                    	midLeft++;
                    midRight--;
                    midLeft++;
                }
                sum4 = sum2 + sum3;
            }
            if(sum4 < target)
            	left++;
            else if(sum4 > target)
            	right--;
            else{
            	left++;
            	right--;
            }
        }
        return result;
    }
}