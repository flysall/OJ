class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if(matrix.length == 0 || matrix[0].length == 0) 
            return list;
        int i = 0, j = -1,  len = matrix[0].length * matrix.length;
        int top = 0, right = matrix[0].length - 1, left = 0, bottom = matrix.length - 1;
        while(top <= bottom || right >= left) {
            while(j < right && list.size() < len) {
                list.add(matrix[i][++j]);
            }
            top++;
            while(i < bottom && list.size() < len) {
                list.add(matrix[++i][j]);
            }
            right--;
            while(j > left && list.size() < len) {
                list.add(matrix[i][--j]);
            }
            bottom--;
            while(i > top && list.size() < len) {
                list.add(matrix[--i][j]);
            }
            left++;
        }
        return list;
    }
}
