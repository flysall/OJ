class Solution {
    private int low, maxLen;
    
    public String longestPalindrome(String s) {
        if (s == null) 
            return s;
        int len = s.length();
        if (len <= 1)
            return s;
        for (int i = 0; i < len; ++i) {
            if (len - i < maxLen / 2) 
                break;
            extendPalindrome(s, i, i);
            extendPalindrome(s, i, i+1);
        }
        return s.substring(low, low + maxLen);
    }
    
    private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k <= s.length()-1 && s.charAt(j) == s.charAt(k)) {
            --j;
            ++k;
        }
        int curLen = k - j - 1;
        if(maxLen < curLen) {
            low = j+1;
            maxLen = curLen; 
        }
    }
}
