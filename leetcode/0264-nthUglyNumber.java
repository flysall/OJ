class Solution {
    public int nthUglyNumber(int n) {
        if (n <= 0)
            return 0;
        int[] dp = new int[n];
        dp[0] = 1;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        int index2 = 1, index3 = 1, index5 = 1;
        for (int i = 1; i < n; i++) {
            int min = Math.min(factor2, Math.min(factor3, factor5));
            dp[i] = min;
            if (min == factor2)
                factor2 = 2 * dp[index2++];
            if (min == factor3)
                factor3 = 3 * dp[index3++];
            if (min == factor5)
                factor5 = 5 * dp[index5++];
        }
        return dp[n-1];
    }
}
