class Solution {
    public int[][] generateMatrix(int n) {
        int target = n*n, cur = 1, i = 0;
        int top = 0, bottom = n-1, left = 0, right = n-1;
        int[][] res = new int[n][n];
        while(true){
            i = left;
            while(i <= right)
                res[top][i++] = cur++;
            if(top > bottom || left > right) break;
            top++; 
            i = top;
            while(i <= bottom)
                res[i++][right] = cur++;
            if(top > bottom || left > right) break;
            right--;
            i = right;
            while(i >= left)
                res[bottom][i--] = cur++;
            if(top > bottom || left > right) break;
            bottom--;
            i = bottom;
            while(i >= top)
                res[i--][left] = cur++;
            left++;
        }
        return res;
    }
}
