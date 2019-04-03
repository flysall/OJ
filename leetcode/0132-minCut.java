class Solution {
    public int minCut(String s) {
        int len = s.length();
        int[] dp = new int[len+1];  // dp[i]代表的是s的第i个字符处(s.charAt(i-1))的minCut.
        boolean[][] isPalindrome = new boolean[len+1][len+1];   // isPalindrome[j][i]代表的是由s的第j个字符和s的第i个字符构成的子串是否是回文串，即s[j-1, i-1](闭区间)是否为回文串.
        for (int i = 0; i <= len; i++)
            dp[i] = i-1;
        for (int i = 2; i <= len; i++) {
            for (int j = i-1; j >= 0; j--) {
                if (j > 0 && s.charAt(i-1) == s.charAt(j-1) && (i-j <= 2 || isPalindrome[j+1][i-1])) {
                    isPalindrome[j][i] = true;
                    dp[i] = Math.min(dp[i], dp[j-1]+1);
                } else if (j == 0) {
                    dp[i] = Math.min(dp[i], dp[i-1]+1);
                }
            }
        }
        return dp[len];
    }
}
