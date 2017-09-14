## 问题描述
最大连续子数组

## 代码实现
```
public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array.length == 0)
            return 0;
        int sum = array[0], tempsum = array[0];
        for(int i = 1; i < array.length; i++){
            tempsum = (tempsum < 0) ? array[i] : tempsum + array[i];
            sum = (tempsum > sum) ? tempsum : sum;
        }
        return sum;
    }
}                        
```