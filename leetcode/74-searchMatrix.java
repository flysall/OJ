class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m * n - 1;
        while(left <= right) {
            int mid = left + ((right - left) >> 1);
            int i = mid / n, j = mid % n;
            if(target == matrix[i][j])
                return true;
            else if(target < matrix[i][j])
                right = mid - 1;
            else
                left = mid + 1;
        }
        return false;        
    }
}
