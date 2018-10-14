## 问题描述
输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。

## 输入描述
输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母

## 代码实现
```java
import java.util.*;

public class Solution {
    public ArrayList<String> Permutation(String str) {
        List<String> res = new ArrayList<>();
        if (str != null && str.length() > 0) {
            permute(str.toCharArray(), 0, res);
            Collections.sort(res);
        }
        return (ArrayList)res;
    }
    private void permute(char[] chars, int start, List<String> res) {
        if (start == chars.length - 1) {
            String str = String.valueOf(chars);
            if (!res.contains(str))
                res.add(str);
        } else {
            for (int j = start; j < chars.length; ++j) {
                swap(chars, start, j);
                permute(chars, start+1, res);
                swap(chars, start, j);
            }
        }
    }
    private void swap(char[] chars, int i, int j) {
        char tmpChar = chars[i];
        chars[i] = chars[j];
        chars[j] = tmpChar;
    }
}
```