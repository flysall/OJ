class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] array = new int[512];
        for(int i = 0; i < s.length(); i++){
            if(array[s.charAt(i)] != array[t.charAt(i) + 256]) return false;
            array[s.charAt(i)] = array[t.charAt(i) + 256] = i+2;
        }
        return true;
    }
}
