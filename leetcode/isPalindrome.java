class Solution {
    public boolean isPalindrome(int x) {
        HashMap<Integer, Integer> map = new HashMap<>();
        if(x < 0)
            return false;
        int temp = x, tail = 0, len = 0, count = 1;
        while(temp != 0){
            temp /= 10;
            len++;
        }
        while(x != 0 && count <= len / 2){
            tail = x % 10;
            map.put(count, tail);
            x = x / 10;
            count++;
        }
        x = len % 2 == 0 ? x : x / 10;
        count--;
        for(int i = count; i >= 1; i--){
            int p = x % 10;
            x = x / 10;
            if(map.get(i) != p)
                return false;
        }
        return true;
    }
}