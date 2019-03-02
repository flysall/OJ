class Solution:
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        flags = [False for _ in range(len(s)+1)]
        flags[0] = True
        for i in range(1, len(s)+1):
            for j in range(0, i):
                if flags[j] and s[j:i] in wordDict:
                    flags[i] = True
                    break
        return flags[len(s)]
        
