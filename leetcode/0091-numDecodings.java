class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int len = s.length();
        int[] dp = new int[len+2];
        dp[len] = dp[len+1] = 1;
        for (int i = len-1; i >= 0; i--) {
            int oneBitVal = Integer.valueOf(s.substring(i, i+1));
            if (oneBitVal == 0) {
                dp[i] = 0;
                continue;
            } else {
                dp[i] += dp[i+1];
            }
            if (i+2 <= len) {
                int twoBitVal = Integer.valueOf(s.substring(i, i+2));
                if (twoBitVal >= 1 && twoBitVal <= 26)
                    dp[i] += dp[i+2];
            }
        }
        return dp[0];
    }
}
