//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
import java.util.*;
public class Solution {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        Set<Integer> set = new HashSet<>();
        for(int val : array) {
            if(set.add(val))
                continue;
            else 
                set.remove(val);
        }
        Iterator<Integer> itr = set.iterator();
        num1[0] = itr.next();
        num2[0] = itr.next();
    }
}