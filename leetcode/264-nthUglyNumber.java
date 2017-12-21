class Solution {
    public int nthUglyNumber(int n) {
        int[] re = new int[n];
        re[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        for(int i = 1; i < n; i++){
            int min = Math.min(Math.min(factor2,factor3),factor5);
            re[i] = min;
            if(factor2 == min)
                factor2 = 2*re[++index2];
            if(factor3 == min)
                factor3 = 3*re[++index3];
            if(factor5 == min)
                factor5 = 5*re[++index5];
        }
        return re[n-1];
    }
}
