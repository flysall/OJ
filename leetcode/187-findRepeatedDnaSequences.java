class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set = new HashSet(), res = new HashSet();
        for(int i = 0; i + 9 < s.length(); i++){
            String cur = s.substring(i, i+10);
            if(!set.add(cur))
                res.add(cur);
        }
        return new ArrayList(res);
    }
}
