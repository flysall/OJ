## 问题描述
 Longest Palindromic Substring：Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

## 代码实现
```java
class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0)
            return "";
        String result = "", temp = "";
        int len = s.length();
        for(int i = 0; i < len; i++){
            int j = -1, k = -1;
            if(i < len - 1 && s.charAt(i) == s.charAt(i+1))
                j = i; k = i + 1;
            if(i > 0 && i < len - 1 && s.charAt(i - 1) == s.charAt(i + 1))
                j = i - 1; k = i + 1;
            while((j > 0) && (k < (len -1)) && s.charAt(j - 1) == s.charAt(k + 1)){
                j--; 
                k++;
            }
            if(k < len - 1 && s.charAt(k + 1) == s.charAt(i)){
                boolean flag = true;
                for(int m = i + 1; m <= k; m++){
                    if(s.charAt(m) != s.charAt(k+1) && flag)
                        flag = false;
                }
                if(flag)
                    k++;
            }
            if(j >= 0 && k < len)
                temp = s.substring(j, k + 1);
            result = temp.length() > result.length() ? temp : result;
        }
        return result == "" ? String.valueOf(s.charAt(0)) : result;
    }
}
```