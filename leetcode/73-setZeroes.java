class Solution {
    public void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<>(), cols = new HashSet<>();
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        Iterator<Interator> itRows = rows.iterator(), itCols = cols.iterator();
        while(itRows.hasNext()){
            int row = itRows.next();
            for(int i = 0; i < matrix[0].length; i++)
                matrix[row][i] = 0;
        }
        while(itCols.hasNext()){
            int col = itCols.next();
            for(int i = 0; i < matrix.length; i++)
                matrix[i][col] = 0;
        }
    }
}
