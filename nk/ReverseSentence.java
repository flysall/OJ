public class Solution {
    public String ReverseSentence(String str) {
        char[] chars = str.toCharArray();
        reverse(chars, 0, chars.length-1);
        for(int i = 0; i < chars.length; ) {
            int j = i;
            for( ; j < chars.length && chars[j] != ' '; )
                j++;
            reverse(chars, i, j-1);
            i = j+1;
        }
        return new String(chars);
    }
    private void reverse(char[] chars, int left, int right) {
        while(left < right) {
            char tmp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = tmp;
        }
    }
}