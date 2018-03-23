class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        if(n == 0) return result;
        int len = n * n, cur = 1;
        int left = 0, right = n-1, top = 0, bottom = n - 1, i = 0, j = -1;
        while(left <= right && top <= bottom) {
            while(j < right && cur <= len)  
                result[i][++j] = cur++;
            top++;
            while(i < bottom && cur <= len) 
                result[++i][j] = cur++;
            right--;
            while(j > left && cur <= len)
                result[i][--j] = cur++;
            bottom--;
            while(i > top && cur <= len)
                result[--i][j] = cur++;
            left++;
        }
        return result;
    }
}
