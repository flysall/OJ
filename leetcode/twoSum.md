## 问题描述
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

## 代码实现
```
import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int temp = 0;
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++){
            temp = target - nums[i];
            if(map.containsKey(temp) && map.get(temp) != i){
                int[] result = new int[2];
                result[0] = i;
                result[1] = map.get(temp);
                return result;
            }
        }
        throw new IllegalArgumentException("Error");
    }
}
```