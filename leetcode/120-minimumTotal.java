class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int sum = 0;
        for(int i = 0; i < triangle.size();  i++){
            Object[] temp =  triangle.get(i).toArray();
            Arrays.sort(temp);
            sum += (Integer) temp[0];
        }
        return sum;
    }
}