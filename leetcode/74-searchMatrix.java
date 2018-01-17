class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix == null) return false;
        if(matrix.length == 1 && matrix[0].length == 0) return false;
        int low = 0, high = matrix.length-1, left = 0, right = matrix[0].length-1;
        while(low < high - 1){
            int mid = low + (high - low) / 2;
            if(target < matrix[mid][0])
                high = mid-1;
            else
                low = mid;
        }
        if(target > matrix[high][0])
            low = high;
        if(matrix[low][0] == target || matrix[high][0] == target)
            return true;
        while(left <= right){
            int mid = left + (right-left) / 2;
            if(target > matrix[low][mid])
                left = mid + 1;
            else if(target < matrix[low][mid])
                right = mid - 1;
            else
                return true;
        }
        return false;
    }
}
