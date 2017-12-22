class Solution {
    public List<String> letterCombinations(String digits) {
        String[] map = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList();
        if(digits == null || digits.length() == 0)  return result;
        String[] digitMap = new String[digits.length()];
        for(int i = 0; i < digits.length(); i++){
            char cur = digits.charAt(i);
            if(cur == '0' || cur == '1') return result;
            digitMap[i] = map[Integer.parseInt(digits.substring(i,i+1))];
        }
        backtrack(digitMap, result, new String(), 0);
        return result;
    }
    private void backtrack(String[] map, List<String> list, String s, int start){
        if(start == map.length-1){
            String str = map[map.length-1];
            for(int i = 0; i < str.length(); i++)
                list.add(new String(s + str.charAt(i)));
            return;
        }
        for(int i = 0; i < map[start].length(); i++){
            s = s + map[start].charAt(i);
            backtrack(map, list, s, start+1);
            s = s.substring(0, s.length()-1);
        }
    }
}
