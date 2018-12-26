class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        int[] dp = new int[len];
        dp[0] = parseSubStringToInt(s, 0, 1) == 0 ? 0 : 1;
        if (dp[0] == 0)
            return 0;
        for (int i = 1; i < len; ++i) {
            int curCode = parseSubStringToInt(s, i, i+1);
            dp[i] += curCode == 0 ? 0 : dp[i-1];
            int code = parseSubStringToInt(s, i-1, i+1);
            int preCode = parseSubStringToInt(s, i-1, i);
            if (preCode != 0 && code <= 26 && code > 0) {
                int preIndex = i-2;
                dp[i] += (preIndex) >= 0 ? dp[preIndex] : 1;
            }
            if (dp[i] == 0)
                break;
        }
        return dp[len-1];
    }
    private int parseSubStringToInt(String str, int start, int end) {
        return Integer.parseInt(str.substring(start, end));
    }
}
