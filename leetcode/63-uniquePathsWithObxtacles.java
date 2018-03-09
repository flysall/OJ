class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] matrix = new int[m][n];
        if(obstacleGrid[0][0] == 1)
            return 0;
        matrix[0][0] = 1;
        for(int i = 1; i < matrix[0].length; i++) {
            if(obstacleGrid[0][i] == 1)
                break;
            matrix[0][i] = 1;
        }
        for(int i = 1; i < matrix.length; i++) {
            if(obstacleGrid[i][0] == 1)
                break;
            matrix[i][0] = 1;
        }
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if(obstacleGrid[i][j] == 1)
                    continue;
                matrix[i][j] = matrix[i-1][j] + matrix[i][j-1];
            }
        }
        return matrix[m-1][n-1];
    }
}
