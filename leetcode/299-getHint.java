class Solution {
    public String getHint(String secret, String guess) {
        Map<Character, Integer> map = new HashMap();
        int bulls = 0, cows = 0, len = secret.length();
        for(char c : secret.toCharArray()){
            int num = map.containsKey(c) ? map.get(c) : 0;
            map.put(c, num+1);
        }
        for(int i = 0; i < len; i++){
            char s = secret.charAt(i), g = guess.charAt(i);
            if(s == g){
                if(map.get(s) <= 0)
                    cows--;
                bulls++;
                map.put(s, map.get(s)-1);
            }
            else if(map.containsKey(g) && map.get(g) > 0){
                cows++;
                map.put(g, map.get(g)-1);
            }
        }
        return String.valueOf(bulls) + "A" + cows + "B";
    }
}
