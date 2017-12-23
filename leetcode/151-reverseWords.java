public class Solution {
    public String reverseWords(String s) {
        String re = "";
        int len = s.length();
        for(int i = 0, j = 0; ; ){
            if(i == len-1){
                re = s.substring(j, i+1) + " " + re;
                break;
            }
            while(i < len && s.charAt(i) != ' ')
                i++;
            re = s.substring(j, i) + " " + re;
            while(i < len && s.charAt(i) == ' ')
                i++;
            if(i == len)
                break;
            j = i;
        }
        return re.trim();
    }
}
