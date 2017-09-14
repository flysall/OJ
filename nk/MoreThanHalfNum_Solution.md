## 问题描述
数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。

## 代码实现
```
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array == null)
            return 0;
        int half = 0;
        int count = 0;
        int temp = 0;
        if(array.length % 2 == 0){
            half = array.length / 2;
        } else{
            half = array.length / 2 + 1;
        }
        for(int i = 0; i < half; i++){
            temp = array[i];
            for(int j = i; j < array.length; j++){
                if(array[j] == temp)
                    count++;
            }
            if(count > array.length / 2)
                return temp;
            else
                count = 0;
        }
        return 0;
    }
}
```