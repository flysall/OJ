## 问题描述

输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。

## 代码实现
```
public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length == 0){
            return false;
        }
        if(sequence.length == 1){
            return true;
        }
        return Verify(sequence, 0, sequence.length - 1);
    }
    
    private boolean Verify(int[] a, int start, int root){
        if(start >= root){
            return true;
        }
        int i = root;
        while(i > start && a[i-1] > a[root]){
            i--;
        }
        for(int j = start; j< i; j++){
            if(a[j] > a[root]){
                return false;
            }
        }
        return Verify(a, start, i-1) && Verify(a, i, root-1);
    }
}
```
