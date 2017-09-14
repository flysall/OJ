## 问题描述
Given a string, find the length of the longest substring without repeating characters.


## 代码实现
```
import java.util.HashMap;

class Solution {
	public int lengthOfLongestSubstring(String s) {
		int result = 0, len = 0, start = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			len++;
			if(map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) >= start) {
				start = map.get(s.charAt(i)) + 1;
				len = i - start + 1;
			} 
			map.put(s.charAt(i), i);
			if (len > result)
				result = len;
		}
		return result;
	}
}

```