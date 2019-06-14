class Solution:
    def wordBreak(self, s, wordDict):
        return self._dfs(s, wordDict, {})
    
    def _dfs(self, s, wordDict, cache):
        if s in cache.keys():
            return cache.get(s)
        res = []
        if len(s) == 0:
            res.append("")
            return res
        for word in wordDict:
            if s.startswith(word):
                sub_results = self._dfs(s[len(word):], wordDict, cache)
                for str in sub_results:
                    combine_str = word + ("" if len(str) == 0 else (" " + str))
                    res.append(combine_str)
        cache[s] = res
        return res
