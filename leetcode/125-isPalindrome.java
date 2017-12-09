class Solution {
    public boolean isPalindrome(String s) {
        if(s.length() == 0) return true;
        int i = 0, j = s.length()-1;
        char head, tail;
        while(i < s.length() && j >= 0){
            head = s.charAt(i);
            tail = s.charAt(j);
            while(!Character.isLetterOrDigit(head) && i+1 < s.length())
                head = s.charAt(++i);
            while(!Character.isLetterOrDigit(tail) && j-1 >= 0)
                tail = s.charAt(--j);
            if(i == s.length()-1 && j == 0) return true;
            if(Character.toLowerCase(head) != Character.toLowerCase(tail)) return false;
            i++;
            j--;
        }
        return true;
    }
}
