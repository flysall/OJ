class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        if word1 == word2:
            return 0
        len1, len2 = len(word1), len(word2)
        if len1 == 0 or len2 == 0:
            return abs(len1 - len2)
        dp = [[0 for j in range(len2+1)] for i in range(len1+1)]
        for i in range(len1+1):
            dp[i][0] = i
        for i in range(len2+1):
            dp[0][i] = i
        for i in range(1, len(dp)):
            for j in range(1, len(dp[i])):
                if word1[i-1] == word2[j-1]:
                    dp[i][j] = dp[i-1][j-1]
                else:
                    dp[i][j] = min(dp[i-1][j-1], dp[i][j-1], dp[i-1][j]) + 1
        return dp[len1][len2]
        
