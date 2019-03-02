class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int area = 0;
        int[] line = new int[matrix[0].length];
        boolean[] isProcessed = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') {
                    line[j]++;
                    isProcessed[j] = false;
                } else {
                    line[j] = 0;
                    isProcessed[j] = true;
                } 
            }
            int len = matrix[i].length;
            for (int j = 0; j < len; j++) {
                if (isProcessed[j])
                    continue;
                int leftMove = 1, rightMove = 1;
                while (j+rightMove  < len && line[j] <= line[j+rightMove]) {
                    if (line[j] == line[j+rightMove])
                        isProcessed[j+rightMove] = true;
                    rightMove++;
                }
                while (j-leftMove >= 0 && line[j] <= line[j-leftMove]) {
                    leftMove++;
                }
                int curArea = line[j] * (rightMove + leftMove - 1);
                area = Math.max(curArea, area);
            }
        }
        return area;
    }
}
