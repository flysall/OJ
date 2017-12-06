class Solution {
    public int lengthOfLastWord(String s) {
        int end = s.length()-1, result = 0;
        while(end >= 0 && s.charAt(end) == ' ')
            end--;
        if(end < 0) return 0;
        int i = end;
        for(; i>=0; i--){
            if(s.charAt(i) == ' '){
                result = end-i;
                break;
            }
        }
        return i == -1 ? end+1: result;
    }
}
