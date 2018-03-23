class Solution {
    private int low = 0, maxLen = 0;
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len < 2) return s;
        for(int i = 0; i < len-1; i++){
            palindrome(s, i, i);
            palindrome(s, i, i+1);
        }
        return s.substring(low, low + maxLen);
    }
    private void palindrome(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        if(right - left - 1 > maxLen){
            maxLen = right - left - 1;
            low = left+1;
        }
    }
}
