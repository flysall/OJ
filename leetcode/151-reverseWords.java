class Solution {
    public String reverseWords(String s) {
        String re = "";
        int len = s.length();
        for(int i = 0, j = 0; ; ){
            while(i < len && s.charAt(i) == ' ')
                i++;
            if(i == len) break;
            j = i;
            while(i < len && s.charAt(i) != ' ')
                i++;
            re = re.length() != 0 ?  s.substring(j, i) + " " + re : s.substring(j, i) + re;
        }
        return re;
    }
}
