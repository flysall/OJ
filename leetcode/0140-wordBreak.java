class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, new HashMap<String, List<String>>());
    }
    
    private List<String> dfs(String s, List<String> wordDict, Map<String, List<String>> cache) {
        if (cache.containsKey(s)) 
            return cache.get(s);
        List<String> res = new LinkedList<>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> subResults = dfs(s.substring(word.length()), wordDict, cache);
                for (String str : subResults) 
                    res.add(word + (str.isEmpty() ? "" : " ") + str);
            }
        }
        cache.put(s, res);
        return res;
    }
}
