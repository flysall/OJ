class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] flags = new boolean[s.length()+1];
        flags[0] = true;
        for (int i = 1; i < s.length()+1; ++i) {
            for (int j = 0; j < i; ++j) {
                if (flags[j] && wordDict.contains(s.substring(j, i))) {
                    flags[i] = true;
                    break;
                }
            }
        }
        return flags[s.length()];
    }
}
