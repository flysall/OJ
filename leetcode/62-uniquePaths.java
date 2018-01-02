class Solution {
    public int uniquePaths(int m, int n) {
        int[][] matrix = new int[m+1][n+1];
        matrix[1][1] = 1;
        for(int i = 2; i < matrix[0].length; i++)
            matrix[1][i] = 1;
        for(int i = 2; i < matrix.length; i++)
            matrix[i][1] = 1;
        for(int i = 2;  i < matrix.length; i++)
            for(int j = 2; j < matrix[0].length; j++)
                matrix[i][j] = matrix[i-1][j] + matrix[i][j-1];
        return matrix[m][n];
    }
}
