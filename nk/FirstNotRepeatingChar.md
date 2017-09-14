## 问题描述
在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置


## 代码实现
```
import java.util.LinkedHashMap;

public class Solution {
    public int FirstNotRepeatingChar(String str) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
        for(int i = 0; i < str.length(); i++){
            if(map.containsKey(str.charAt(i))){
                int times = map.get(str.charAt(i));
                map.put(str.charAt(i), ++times);
            } else{
                map.put(str.charAt(i), 1);
            }
        }
       	int pos = -1;
        for(int i = 0; i < str.length(); i++){
            if(map.get(str.charAt(i)) == 1)
                return i;
        }
        return pos;
    }
}
```