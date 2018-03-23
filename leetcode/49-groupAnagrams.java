class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0 || strs == null) return new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap();
        for(String s : strs){
            char[] cur = s.toCharArray();
            Arrays.sort(cur);
            String keyStr = new String(cur);
            if(!map.containsKey(keyStr))
                map.put(keyStr, new ArrayList<String>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
