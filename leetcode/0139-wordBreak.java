class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len+1];
        List<Integer> breakIndexs = new ArrayList<>();  // 记录下能够正确分割处的下标，减少不必要的遍历，降低Runtime.
        dp[0] = true;
        breakIndexs.add(0);
        for (int i = 1; i <= len; i++) {
            int lengthOfBreakIndexs = breakIndexs.size();
            for (int j = lengthOfBreakIndexs-1; j >= 0; j--) {
                int breakIndex = breakIndexs.get(j);
                String subStr = s.substring(breakIndex, i);
                if (dp[breakIndex] && wordDict.contains(subStr)) {
                    dp[i] = true;
                    breakIndexs.add(i);
                    break;
                }
            }
        }
        return dp[len];
    }
}

/*
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
*/
