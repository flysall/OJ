class Solution {
    public int numSquares(int n) {
        int[] re = new int[n+1];
        for(int i = 1; i < re.length; i++){
            int min = Integer.MAX_VALUE;
            for(int j = 1; j * j <= i; j++)
                min = Math.min(min, re[i-j*j]+1);
            re[i] = min;
        }
        return re[n];
    }
}
