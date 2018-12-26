class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] res = new int[triangle.size()+1];
        for (int i = triangle.size()-1; i >= 0; --i) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j < row.size(); ++j) {
                res[j] = Math.min(res[j], res[j+1]) + row.get(j);
            }
        }
        return res[0];
    }
}
