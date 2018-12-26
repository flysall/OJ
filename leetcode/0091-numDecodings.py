class Solution:
    def numDecodings(self, s):
        """
        :type s: str
        :rtype: int
        """
        str_len = len(s)
        dp = [0 for _ in range(str_len+1)]
        dp[str_len] = 1
        dp[str_len-1] = 0 if s[str_len-1:str_len] == "0" else 1
        for i in range(str_len-2, -1, -1):
            if s[i:i+1] == "0":
                continue
            code = int(s[i:i+2])
            dp[i] = dp[i+1] + dp[i+2] if code <= 26 else dp[i+1]
            if dp[i] == 0:
                break
        return dp[0]

