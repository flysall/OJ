class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0 || strs == null) return "";
        if(strs.length == 1) return strs[0];
        int end = 1;
        for(int i = 1; i <= strs[0].length(); end++, i++){
            String tmp = strs[0].substring(0, end);
            boolean flag = true;
            for(int j = 0; j < strs.length; j++){
                if(!strs[j].startsWith(tmp)){
                    flag = false;
                    break;
                }
            }
            if(flag == false)
                break;
        }
        return strs[0].substring(0, end-1);
    }
}
