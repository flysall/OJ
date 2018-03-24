public class Solution {
    public String LeftRotateString(String str,int n) {
        if(str == null || str.length() == 0) return "";
        int len = str.length();
        n %= len;
        String str1 = str.substring(0, n);
        String str2 = str.substring(n);
        return str2 + str1;
    }
}