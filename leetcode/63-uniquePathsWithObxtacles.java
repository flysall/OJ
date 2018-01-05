class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1) return 0;
        for(int i = 1; i < obstacleGrid[0].length; i++){
            if(obstacleGrid[0][i] == 0) obstacleGrid[0][i] = 1;
            else{
                while(i < obstacleGrid[0].length)
                    obstacleGrid[0][i++] = 0;
                break;
            }
        }
        for(int i = 1; i < obstacleGrid.length; i++){
            if(obstacleGrid[i][0] == 0) obstacleGrid[i][0] = 1;
            else{
                while(i < obstacleGrid.length)
                    obstacleGrid[i++][0] = 0;
                break;
            }
        }
        obstacleGrid[0][0] = 1;
        for(int i = 1; i < obstacleGrid.length; i++){
            for(int j = 1; j < obstacleGrid[0].length; j++){
                if(obstacleGrid[i][j] == 1)
                    obstacleGrid[i][j] = 0;
                else
                    obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
            }
        }
        return obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}
