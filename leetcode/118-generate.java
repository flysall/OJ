class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> preTemp = null;
        for(int i = 1; i <= numRows; i++){
            if(i == 1){
                List temp = new ArrayList<Integer>();
                temp.add(1);
                result.add(temp);
            }
            else if(i == 2){
                List temp = new ArrayList<Integer>();
                temp.add(1);
                temp.add(1);
                preTemp = temp;
                result.add(temp);
            } else{
                List temp = new ArrayList<Integer>();
                temp.add(1);
                for(int j = 2; j <= i-1; j++){
                    temp.add(preTemp.get(j-2) + preTemp.get(j - 1));
                }
                temp.add(1);
                preTemp = temp;
                result.add(temp);
            }
        }
        return result;
    }
}